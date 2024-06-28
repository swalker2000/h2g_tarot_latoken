package com.questionnairetarot.repository.data

/**
 * Колода.
 * @param id уникальное имя колоды латиницей без пробелов, аналог username в telegram
 */
data class Deck(val id : String) {
    /**
     * Карты содержащиеся в колоде.
     */
    val cards = mutableListOf<Card>()

    /**
     *  @param name имя колоды.
     *  @param id уникальное имя колоды латиницей без пробелов, аналог username в telegram
     */
    constructor(id : String, name : String, fortuneTeller : String) : this(id)
    {
        this.name = name
        this.fortuneTeller= fortuneTeller
    }

    /**
     * Имя колоды.
     */
    var name : String = ""

    /**
     * Описание колоды.
     */
    var fortuneTeller : String = ""
}