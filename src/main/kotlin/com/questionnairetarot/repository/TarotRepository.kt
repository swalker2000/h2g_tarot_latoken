package com.questionnairetarot.repository

import com.lang.Dictionary
import com.questionnairetarot.repository.data.Card
import com.questionnairetarot.repository.data.Deck
import java.util.Optional

/**
 * Репозиторий различных видов карт таро.
 */
object TarotRepository {

    private val olderDeck = Deck("older", Dictionary.getDol().cards.olderDeck.name , Dictionary.getDol().cards.olderDeck.fortuneTeller).apply {
        cards.add(Card("fool", Dictionary.getDol().cards.olderDeck.fool, id))
        cards.add(Card("magician", Dictionary.getDol().cards.olderDeck.magician, id))
        cards.add(Card("highPriestess", Dictionary.getDol().cards.olderDeck.highPriestess, id))
        cards.add(Card("empress", Dictionary.getDol().cards.olderDeck.empress, id))
        cards.add(Card("emperor", Dictionary.getDol().cards.olderDeck.emperor, id))
        cards.add(Card("pope", Dictionary.getDol().cards.olderDeck.pope, id))
        cards.add(Card("lovers", Dictionary.getDol().cards.olderDeck.lovers, id))
        cards.add(Card("chariot", Dictionary.getDol().cards.olderDeck.chariot, id))
        cards.add(Card("justice", Dictionary.getDol().cards.olderDeck.justice, id))
        cards.add(Card("hermit", Dictionary.getDol().cards.olderDeck.hermit, id))
        cards.add(Card("wheelOfFortune", Dictionary.getDol().cards.olderDeck.wheelOfFortune, id))
        cards.add(Card("force", Dictionary.getDol().cards.olderDeck.force, id))
        cards.add(Card("hangedMan", Dictionary.getDol().cards.olderDeck.hangedMan , id))
        cards.add(Card("death", Dictionary.getDol().cards.olderDeck.death , id))
        cards.add(Card("temperance", Dictionary.getDol().cards.olderDeck.temperance, id))
        cards.add(Card("devil", Dictionary.getDol().cards.olderDeck.devil , id))
        cards.add(Card("tower", Dictionary.getDol().cards.olderDeck.tower , id))
        cards.add(Card("star", Dictionary.getDol().cards.olderDeck.star , id))
        cards.add(Card("moon", Dictionary.getDol().cards.olderDeck.moon , id))
        cards.add(Card("sun", Dictionary.getDol().cards.olderDeck.sun , id))
        cards.add(Card("judgement", Dictionary.getDol().cards.olderDeck.judgement , id))
        cards.add(Card("world", Dictionary.getDol().cards.olderDeck.world , id))
    }

    private val lowDeck = Deck("low", Dictionary.getDol().cards.lowDeck.name, "предсказательница София").apply {
        cards.add(Card("aceOfCups",  Dictionary.getDol().cards.lowDeck.aceOfCups, id))
        cards.add(Card("aceOfPentacles",  Dictionary.getDol().cards.lowDeck.aceOfPentacles, id))
        cards.add(Card("aceOfSwords",  Dictionary.getDol().cards.lowDeck.aceOfSwords, id))
        cards.add(Card("aceOfWands",  Dictionary.getDol().cards.lowDeck.aceOfWands, id))
        cards.add(Card("kingOfCups",  Dictionary.getDol().cards.lowDeck.kingOfCups, id))
        cards.add(Card("kingOfPentacles",  Dictionary.getDol().cards.lowDeck.kingOfPentacles, id))
        cards.add(Card("kingOfSwords",  Dictionary.getDol().cards.lowDeck.kingOfSwords, id))
        cards.add(Card("kingOfWands",  Dictionary.getDol().cards.lowDeck.kingOfWands, id))
        cards.add(Card("knightOfCups",  Dictionary.getDol().cards.lowDeck.knightOfCups, id))
        cards.add(Card("knightOfPentacles",  Dictionary.getDol().cards.lowDeck.knightOfPentacles, id))
        cards.add(Card("knightOfSwords",  Dictionary.getDol().cards.lowDeck.knightOfSwords, id))
        cards.add(Card("knightOfWands",  Dictionary.getDol().cards.lowDeck.knightOfWands, id ))
        cards.add(Card("pageOfCups",  Dictionary.getDol().cards.lowDeck.pageOfCups, id ))
        cards.add(Card("pageOfPentacles",  Dictionary.getDol().cards.lowDeck.pageOfPentacles , id))
        cards.add(Card("pageOfSwords",  Dictionary.getDol().cards.lowDeck.pageOfSwords, id ))
        cards.add(Card("pageOfWands",  Dictionary.getDol().cards.lowDeck.pageOfWands , id))
        cards.add(Card("queenOfCups",  Dictionary.getDol().cards.lowDeck.queenOfCups , id))
        cards.add(Card("queenOfPentacles",  Dictionary.getDol().cards.lowDeck.queenOfPentacles, id))
        cards.add(Card("queenOfSwords",  Dictionary.getDol().cards.lowDeck.queenOfSwords, id ))
        cards.add(Card("queenOfWands",  Dictionary.getDol().cards.lowDeck.queenOfWands, id))
        cards.add(Card("cups2",  Dictionary.getDol().cards.lowDeck.cups2, id ))
        cards.add(Card("cups3",  Dictionary.getDol().cards.lowDeck.cups3 , id))
        cards.add(Card("cups4",  Dictionary.getDol().cards.lowDeck.cups4 , id))
        cards.add(Card("cups5",  Dictionary.getDol().cards.lowDeck.cups5, id ))
        cards.add(Card("cups6",  Dictionary.getDol().cards.lowDeck.cups6, id))
        cards.add(Card("cups7",  Dictionary.getDol().cards.lowDeck.cups7, id ))
        cards.add(Card("cups8",  Dictionary.getDol().cards.lowDeck.cups8, id ))
        cards.add(Card("cups9",  Dictionary.getDol().cards.lowDeck.cups9 , id))
        cards.add(Card("cups10",  Dictionary.getDol().cards.lowDeck.cups10, id ))
        cards.add(Card("pentacles2",  Dictionary.getDol().cards.lowDeck.pentacles2, id ))
        cards.add(Card("pentacles3",  Dictionary.getDol().cards.lowDeck.pentacles3 , id))
        cards.add(Card("pentacles4",  Dictionary.getDol().cards.lowDeck.pentacles4 , id))
        cards.add(Card("pentacles5",  Dictionary.getDol().cards.lowDeck.pentacles5 , id))
        cards.add(Card("pentacles6",  Dictionary.getDol().cards.lowDeck.pentacles6 , id))
        cards.add(Card("pentacles7",  Dictionary.getDol().cards.lowDeck.pentacles7 , id))
        cards.add(Card("pentacles8",  Dictionary.getDol().cards.lowDeck.pentacles8 , id))
        cards.add(Card("pentacles9",  Dictionary.getDol().cards.lowDeck.pentacles9 , id))
        cards.add(Card("pentacles10",  Dictionary.getDol().cards.lowDeck.pentacles10 , id))
        cards.add(Card("swords2",  Dictionary.getDol().cards.lowDeck.swords2 , id))
        cards.add(Card("swords3",  Dictionary.getDol().cards.lowDeck.swords3, id ))
        cards.add(Card("swords4",  Dictionary.getDol().cards.lowDeck.swords4 , id))
        cards.add(Card("swords5",  Dictionary.getDol().cards.lowDeck.swords5, id ))
        cards.add(Card("swords6",  Dictionary.getDol().cards.lowDeck.swords6 , id))
        cards.add(Card("swords7",  Dictionary.getDol().cards.lowDeck.swords7, id ))
        cards.add(Card("swords8",  Dictionary.getDol().cards.lowDeck.swords8, id ))
        cards.add(Card("swords9",  Dictionary.getDol().cards.lowDeck.swords9 , id))
        cards.add(Card("swords10",  Dictionary.getDol().cards.lowDeck.swords10, id ))
        cards.add(Card("wands2",  Dictionary.getDol().cards.lowDeck.wands2 , id))
        cards.add(Card("wands3",  Dictionary.getDol().cards.lowDeck.wands3, id ))
        cards.add(Card("wands4",  Dictionary.getDol().cards.lowDeck.wands4, id ))
        cards.add(Card("wands5",  Dictionary.getDol().cards.lowDeck.wands5, id ))
        cards.add(Card("wands6",  Dictionary.getDol().cards.lowDeck.wands6, id ))
        cards.add(Card("wands7",  Dictionary.getDol().cards.lowDeck.wands7, id ))
        cards.add(Card("wands8",  Dictionary.getDol().cards.lowDeck.wands8, id ))
        cards.add(Card("wands9",  Dictionary.getDol().cards.lowDeck.wands9 , id))
        cards.add(Card("wands10",  Dictionary.getDol().cards.lowDeck.wands10, id ))
    }

    private val fullDeck = Deck("full", Dictionary.getDol().cards.fullDeckName, "предсказательница София").apply {
        listOf(olderDeck, lowDeck).flatMap { it.cards }.forEach { cards.add(it) }
    }

    private val deckSet = setOf<Deck>(olderDeck, lowDeck, fullDeck)

    /**
     * Получить список id всех колод.
     */
    fun getDeckIdList() : List<String>
    {
        return deckSet.map{it.id}
    }

    /**
     * Получить список всех колод.
     */
    fun getDeckList() : List<Deck>
    {
        return deckSet.toList()
    }

    /**
     * Получить колоду по ее id.
     */
    fun getDeck(deckId : String) : Optional<Deck>
    {
        if(deckSet.any { it.id == deckId })
            return Optional.of(deckSet.first { it.id==deckId })
        else
            return Optional.empty()
    }


}