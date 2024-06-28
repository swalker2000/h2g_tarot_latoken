package com

import com.lang.Dictionary
import com.lang.SupportedLanguages
import com.questionnairetarot.telebot.Telebot
import org.slf4j.LoggerFactory
import com.h2g.common.logger.LogAction



suspend fun main() {
    val logger = LoggerFactory.getLogger("Main")

    com.h2g.common.logger.LoggerFactory.debugLogAction = LogAction { logger.debug(it) }
    com.h2g.common.logger.LoggerFactory.infoLogAction = LogAction { logger.info(it) }
    com.h2g.common.logger.LoggerFactory.warnLogAction = LogAction { logger.warn(it) }
    com.h2g.common.logger.LoggerFactory.errorLogAction = LogAction { logger.error(it) }
    System.getenv("LANG")?.let{langCodeEnv->
        logger.info("Language env: $langCodeEnv")
        val supportedLanguage = SupportedLanguages.values().firstOrNull() { it.toString()==langCodeEnv }
        if(supportedLanguage!=null) {
            logger.info("Current language : $supportedLanguage")
            Dictionary.currentLanguage = supportedLanguage!!
        }
        else
        {
            logger.error("langCodeEnv not found")
        }
    }
    val telebot = Telebot()
    telebot.run()
}