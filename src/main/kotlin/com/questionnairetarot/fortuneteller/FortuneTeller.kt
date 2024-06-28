package com.questionnairetarot.fortuneteller

import com.h2g.common.aiconnector.AiConnector
import com.h2g.common.imagerepository.ImageRepository
import com.h2g.common.repository.data.questionnaire.QuestionnaireMessage
import com.lang.Dictionary
import com.questionnairetarot.repository.data.Card
import com.questionnairetarot.repository.data.Deck
import dev.inmo.tgbotapi.requests.abstracts.InputFile
import org.slf4j.LoggerFactory
import java.io.File
import kotlin.random.Random

class FortuneTeller(private val deck  :Deck, private val questionnaireInfo : QuestionnaireMessage) {

    private val logger = LoggerFactory.getLogger(FortuneTeller::class.java)

    private val CARDS_COUNT = 3

    private val aiConnector = AiConnector(System.getenv("chatGptUrl"))

    private val fortuneTellerRequestData = FortuneTellerRequestData(deck)

    private fun currentQuestionNumber() = fortuneTellerRequestData.userResponseList.size

    @Volatile
    var tellFortunesInProcess = false
        private set

    /**
     * Remembers the user's answers to questions and the AI's answer.
     */
    data class Cash(val userAnswers : MutableList<String> = mutableListOf(), var aiAnswer: String = "")

    /**
     * Remembers the user's answers to questions and the AI's answer.
     */
    val cash = Cash()


    /**
     * The message that the user sees when generating a response.
     */
    fun getWaitMessage() : String
    {
        return questionnaireInfo.stopMessage
    }


    /**
     * After calling this method, the getQuestionText() function will return the next question
     * (if the current question is not the last one).
     */
    fun getQuestionText(): String
    {
        return questionnaireInfo.questionMap[currentQuestionNumber()]!!
    }

    /**
     * Provide an answer to the current question.
     *
     * @return Are we done collecting the list of questions?
     */
    fun setAnswerOnQuestion(answer  :String) : Boolean
    {
        fortuneTellerRequestData.userResponseList.add(answer)
        cash.userAnswers.add(answer)
        return isTestOver()
    }

    /**
     * @return Are we done collecting the list of questions?
     */
    private fun isTestOver(): Boolean
    {
        return currentQuestionNumber()>=questionnaireInfo.questionMap.size
    }



    fun tellFortunes() : FortuneTellerResponseData
    {
        tellFortunesInProcess = true
        val cards = takeCards(fortuneTellerRequestData.deck, CARDS_COUNT)
        val messageForAi =  Dictionary.getDol().getMessageForAi(
            questionnaireInfo.messageBeforeQuestions,
            fortuneTellerRequestData.userResponseList[0],
            fortuneTellerRequestData.userResponseList[1],
            fortuneTellerRequestData.userResponseList[2],
            fortuneTellerRequestData.userResponseList[3],
            cards.map { it.name }
            )
        //logger.info("Message for AI:\n$messageForAi")
        try {
            var aiAnswer = aiConnector.request(messageForAi)
            //Make card names bold
            cards.forEach { card ->
                aiAnswer = aiAnswer.replace(card.name, "<b>${card.name}</b>")
            }
            cash.aiAnswer = aiAnswer
            val descriptionToCard = cards.associate { Pair(it.name, it.image) }
            return FortuneTellerResponseData(aiAnswer, descriptionToCard)
        }
        catch (ex: Exception)
        {
            logger.error(ex.stackTraceToString())
            return FortuneTellerResponseData(ex.message.toString(), mapOf())
        }
        finally {
            tellFortunesInProcess= false
        }
    }

    /**
     * Take cards from deck.
     */
    private fun takeCards(deck: Deck, cardCount : Int) : List<Card>
    {
        val cardList = mutableSetOf<Card>()
        while (cardList.size<cardCount)
        {
            val randomInt = Random.nextInt(0, deck.cards.size)
            val card = deck.cards[randomInt]
            cardList.add(card)
        }
        return cardList.toList()
    }


}