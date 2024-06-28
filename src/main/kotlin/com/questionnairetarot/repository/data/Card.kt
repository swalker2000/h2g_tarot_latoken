package com.questionnairetarot.repository.data

import com.h2g.common.imagerepository.ImageRepository
import dev.inmo.tgbotapi.requests.abstracts.InputFile

/**
 * Карта.
 * @param id уникальное имя карты латиницей без пробелов, аналог username в telegram
 * @param imageDirectory директория где хранится изображения карты :TODO придумать как убрать, не прибегая к загрузке изображений при инициализации колоды
 */
data class Card(val id : String, private val imageDirectory : String)
{
    /**
     *  @param name имя карты.
     *  @param id уникальное имя карты латиницей без пробелов, аналог username в telegram
     *  @param imageDirectory директория где хранится изображения карты :TODO придумать как убрать, не прибегая к загрузке изображений при инициализации колоды
     */
    constructor(id : String, name : String, imageDirectory : String) : this(id, imageDirectory)
    {
        this.name = name
    }


    /**
     * Рисунок карты.
     */
    val image : InputFile
        get(){
            return ImageRepository.get(imageDirectory, id)
    }

    /**
     * Имя карты.
     */
    var name : String = ""

    /**
     * Описание карты.
     */
    var description : String = ""
}
