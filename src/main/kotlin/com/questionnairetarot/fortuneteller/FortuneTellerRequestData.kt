package com.questionnairetarot.fortuneteller

import com.questionnairetarot.repository.data.Deck

data class FortuneTellerRequestData(val deck : Deck) {

    val userResponseList = mutableListOf<String>()


}