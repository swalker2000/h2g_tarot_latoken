package com.questionnairetarot.telebot
import com.h2g.common.repository.H2gRepository
import com.h2g.common.repository.data.newanswers.NewAnswersMessage
import com.h2g.common.repository.data.newanswers.PersonalDataMessage
import com.lang.Dictionary
import com.questionnairetarot.fortuneteller.FortuneTeller
import com.questionnairetarot.repository.TarotRepository
import dev.inmo.tgbotapi.extensions.api.send.media.sendPhoto
import dev.inmo.tgbotapi.extensions.api.send.send
import dev.inmo.tgbotapi.extensions.api.telegramBot
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onText
import dev.inmo.tgbotapi.extensions.utils.asCommonUser
import dev.inmo.tgbotapi.extensions.utils.asUser
import dev.inmo.tgbotapi.extensions.utils.extensions.raw.from
import dev.inmo.tgbotapi.extensions.utils.updates.hasNoCommands
import dev.inmo.tgbotapi.extensions.utils.userOrNull
import dev.inmo.tgbotapi.requests.abstracts.InputFile
import dev.inmo.tgbotapi.types.chat.PreviewChat
import dev.inmo.tgbotapi.types.message.HTML
import dev.inmo.tgbotapi.types.message.abstracts.CommonMessage
import dev.inmo.tgbotapi.types.message.content.TextContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory


class Telebot {

    private val QUESTIONNAIRE_NAME = System.getenv("questionnaireName")

    private val questionnaireInfo = H2gRepository.get.questionnaire(QUESTIONNAIRE_NAME, true)

    private val bot = telegramBot(questionnaireInfo.tgToken)

    private val logger = LoggerFactory.getLogger(Telebot::class.java)

    private var startText = Dictionary.getDol().startText

    private val tgIdToFortuneTeller = mutableMapOf<Long, FortuneTeller>()

    init {
        TarotRepository.getDeckList().forEach{deck->
            startText += "\n/${deck.id} - ${deck.name}"
        }
    }


    suspend fun run()
    {
        bot.buildBehaviourWithLongPolling {
            //ON COMMAND
            onCommand("start"){
                sendMessageToUser(it.chat, startText)
            }
            onCommand("run")
            {commonMessage->
                //:TODO сделать пометку для главной колоды.
                newSenseAction("older", commonMessage)
            }
            TarotRepository.getDeckIdList().forEach { deckId->
                onCommand("${deckId}"){commonMessage->
                    newSenseAction(deckId, commonMessage)
                }
            }
            //ON MESSAGE
            onText{commonMessage->
                if(commonMessage.hasNoCommands())
                    newMessage(commonMessage)

            }
        }.join()
    }

    private suspend fun CoroutineScope.newMessage(commonMessage: CommonMessage<TextContent>)
    {
        if(tgIdToFortuneTeller.containsKey(commonMessage.chat.id.chatId))
        {
            val fortuneTeller = tgIdToFortuneTeller[commonMessage.chat.id.chatId]!!
            val questionsIsOver : Boolean = fortuneTeller.setAnswerOnQuestion(commonMessage.content.text)
            if(fortuneTeller.tellFortunesInProcess)
            {
                sendMessageToUser(commonMessage.chat, fortuneTeller.getWaitMessage())
            }
            else if(!questionsIsOver) {
                val questionText = fortuneTeller.getQuestionText()
                sendMessageToUser(commonMessage.chat, questionText)
            }
            else{
                sendMessageToUser(commonMessage.chat, fortuneTeller.getWaitMessage())
                launch {
                        val fortuneTellerAnswer = fortuneTeller.tellFortunes()
                        fortuneTellerAnswer.images.forEach { (name, file) ->
                            sendImageToUser(commonMessage.chat,name, file)
                        }
                        sendMessageToUser(commonMessage.chat, fortuneTellerAnswer.message, false, true)
                        if(questionnaireInfo.advertising.length>1)
                            sendMessageToUser(commonMessage.chat, questionnaireInfo.advertising, false, false)
                        launch {
                            sendResults(commonMessage, fortuneTeller)
                        }
                        tgIdToFortuneTeller.remove(commonMessage.chat.id.chatId)
                }
            }
        }
        else
        {
            sendMessageToUser(commonMessage.chat, startText, true)
        }
    }


    private suspend fun newSenseAction(deckId : String, commonMessage: CommonMessage<TextContent>)
    {
        val deck = TarotRepository.getDeck(deckId)
        if(deck.isPresent) {
            val fortuneTeller = FortuneTeller(deck.get(), questionnaireInfo)
            tgIdToFortuneTeller[commonMessage.chat.id.chatId] = fortuneTeller
            sendMessageToUser(commonMessage.chat, fortuneTeller.getQuestionText())
        }
        else {
            sendMessageToUser(commonMessage.chat, "Command not found.", true)
        }
    }

    private suspend fun sendMessageToUser(chat: PreviewChat, message : String, warnLog : Boolean = false, html : Boolean = false)
    {
        if(warnLog)
            logger.warn("TD[${chat.id.chatId}] : $message")
        else
            logger.info("TD[${chat.id.chatId}] : $message")
        if(html)
            bot.send(chat, message, parseMode = HTML)
        else
            bot.send(chat,message)
    }
    private suspend fun sendImageToUser(chat: PreviewChat, message : String, file : InputFile)
    {
        logger.info("TD_IMAGE[${chat.id.chatId}] : $message")
        bot.sendPhoto(chat.id, file, message)

    }

    /**
     * Send test results to the server.
     */
    private suspend fun sendResults(commonMessage: CommonMessage<TextContent>, fortuneTeller: FortuneTeller)
    {
        val chat  = commonMessage.chat
        val personalDataMessage = PersonalDataMessage(chat.id.chatId.toString())
        fun addIfNotEmpty(paramName : String, paramValue : String?)
        {
            if(!paramValue.isNullOrEmpty())
                personalDataMessage.data[paramName]=paramValue
        }
        val user = commonMessage.from
        if(user!=null) {
            addIfNotEmpty("firstName", user.firstName)
            addIfNotEmpty("lastName", user.lastName)
            if(user.username!=null)
                addIfNotEmpty("username", user.username!!.withoutAt)
            val commonUser = user.asCommonUser()
            if(commonUser!=null)
            {
                addIfNotEmpty("isPremium", commonUser.isPremium.toString())
                addIfNotEmpty("languageCode", commonUser.languageCode)
            }

        }
        val newAnswersMessage = NewAnswersMessage(personalDataMessage, QUESTIONNAIRE_NAME)
        newAnswersMessage.aiAnswer = fortuneTeller.cash.aiAnswer
        newAnswersMessage.answerList = fortuneTeller.cash.userAnswers.mapIndexed { index, s -> Pair(index, s) }.toMap()
        H2gRepository.set.answers(newAnswersMessage)
    }

}