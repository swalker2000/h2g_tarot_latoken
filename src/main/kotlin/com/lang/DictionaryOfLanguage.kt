package com.lang

interface DictionaryOfLanguage {

    val cards :Cards

    fun getMessageForAi(
        latokenAbout : String,
        userName : String,
        age : String,
        profession : String,
        question : String,
        cardNames : List<String>
    ): String

    val startText : String

    interface Cards
    {
        val olderDeck : OlderDeck
        val lowDeck : LowDeck
        val fullDeckName :String

        interface Deck
        {
            val name : String
            val fortuneTeller : String
        }
        interface OlderDeck : Deck {
            val fool: String
            val magician: String
            val highPriestess: String
            val empress: String
            val emperor: String
            val pope: String
            val lovers: String
            val chariot: String
            val justice: String
            val hermit: String
            val wheelOfFortune: String
            val force: String
            val hangedMan: String
            val death: String
            val temperance: String
            val devil: String
            val tower: String
            val star: String
            val moon: String
            val sun: String
            val judgement: String
            val world: String
        }

        interface LowDeck :Deck {
            val aceOfCups: String
            val aceOfPentacles: String
            val aceOfSwords: String
            val aceOfWands: String
            val kingOfCups: String
            val kingOfPentacles: String
            val kingOfSwords: String
            val kingOfWands: String
            val knightOfCups: String
            val knightOfPentacles: String
            val knightOfSwords: String
            val knightOfWands: String
            val pageOfCups: String
            val pageOfPentacles: String
            val pageOfSwords: String
            val pageOfWands: String
            val queenOfCups: String
            val queenOfPentacles: String
            val queenOfSwords: String
            val queenOfWands: String
            val cups2: String
            val cups3: String
            val cups4: String
            val cups5: String
            val cups6: String
            val cups7: String
            val cups8: String
            val cups9: String
            val cups10: String
            val pentacles2: String
            val pentacles3: String
            val pentacles4: String
            val pentacles5: String
            val pentacles6: String
            val pentacles7: String
            val pentacles8: String
            val pentacles9: String
            val pentacles10: String
            val swords2: String
            val swords3: String
            val swords4: String
            val swords5: String
            val swords6: String
            val swords7: String
            val swords8: String
            val swords9: String
            val swords10: String
            val wands2: String
            val wands3: String
            val wands4: String
            val wands5: String
            val wands6: String
            val wands7: String
            val wands8: String
            val wands9: String
            val wands10: String
        }
    }

}