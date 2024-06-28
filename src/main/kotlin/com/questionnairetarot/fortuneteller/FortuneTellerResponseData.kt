package com.questionnairetarot.fortuneteller

import dev.inmo.tgbotapi.requests.abstracts.InputFile

/**
 * @param images <image description, image>
 */
class FortuneTellerResponseData(val message : String, val images : Map<String, InputFile> ) {

}