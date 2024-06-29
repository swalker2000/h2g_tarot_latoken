package com.lang.ru

import com.lang.DictionaryOfLanguage

class DictionaryOfRussian : DictionaryOfLanguage {
    override val cards: DictionaryOfLanguage.Cards
        get() = RussianCards()

    override fun getMessageForAi(
        latokenAbout : String,
        userName: String,
        age : String,
        profession: String,
        question: String,
        cardNames: List<String>
    ): String {
        return "$latokenAbout\n\n На основании текста выше представь, что ты - предсказатель и умеешь гадать на картах Таро. \n" +
                "Ты помогаешь новичкам и опытным трейдерам Latoken узнать их судьбу и судьбу Latoken\n"+
                "Ты всегда уверен в своих предсказаниях. \n" +
                "К тебе пришел клиент ${userName} возрастом ${age} лет " +
                "зарабатывающий на жизнь профессией ${profession}. " +
                "Хочет узнать : ${question}" +
                " Ты вытащил следующие 3 карты : ${cardNames[0]}, " +
                "${cardNames[1]}, ${cardNames[2]}." +
                "Напиши свое предсказание. Опиши, что означает каждая из этих карт. " +
                "Добавь мистицизма в описание. Добавь пару слов про Latoken на тему предсказания. Твой ответ не должен превышать 700 символов и быть на русском языке."
    }

    override val startText: String =  """
        |Выбери расклад, который ты хочешь сделать.
        |Если не знаешь, просто нажми /run.
        |/start - главное меню (вот это меню)
        """.trimMargin()

    class RussianCards : DictionaryOfLanguage.Cards
    {
        class RussianOlderDeck : DictionaryOfLanguage.Cards.OlderDeck
        {
            override val fool: String
                get() = "Шут"
            override val magician: String
                get() = "Маг"
            override val highPriestess: String
                get() = "Верховная Жрица"
            override val empress: String
                get() = "Императрица"
            override val emperor: String
                get() = "Император"
            override val pope: String
                get() = "Верховный жрец"
            override val lovers: String
                get() = "Влюбленные"
            override val chariot: String
                get() = "Повозка"
            override val justice: String
                get() = "Справедливость"
            override val hermit: String
                get() = "Отшельник"
            override val wheelOfFortune: String
                get() = "Колесо Судьбы"
            override val force: String
                get() = "Сила"
            override val hangedMan: String
                get() = "Повешенный"
            override val death: String
                get() = "Смерть"
            override val temperance: String
                get() = "Умеренность"
            override val devil: String
                get() = "Дьявол"
            override val tower: String
                get() = "Башня"
            override val star: String
                get() = "Звезда"
            override val moon: String
                get() = "Луна"
            override val sun: String
                get() = "Солнце"
            override val judgement: String
                get() = "Суд"
            override val world: String
                get() = "Мир"
            override val name: String
                get() = "Старшая колода"
            override val fortuneTeller: String
                get() = "предсказательница София"

        }

        class RussianLowDeck : DictionaryOfLanguage.Cards.LowDeck
        {
            override val aceOfCups: String
                get() = "Туз кубков"
            override val aceOfPentacles: String
                get() = "Туз пентаклей"
            override val aceOfSwords: String
                get() = "Туз мечей"
            override val aceOfWands: String
                get() = "Туз жезлов"
            override val kingOfCups: String
                get() = "Король кубков"
            override val kingOfPentacles: String
                get() = "Король пентаклей"
            override val kingOfSwords: String
                get() = "Король мечей"
            override val kingOfWands: String
                get() = "Король жезлов"
            override val knightOfCups: String
                get() = "Рыцарь кубков"
            override val knightOfPentacles: String
                get() = "Рыцарь пентаклей"
            override val knightOfSwords: String
                get() = "Рыцарь мечей"
            override val knightOfWands: String
                get() = "Рыцарь жезлов"
            override val pageOfCups: String
                get() = "Паж кубков"
            override val pageOfPentacles: String
                get() = "Паж пентаклей"
            override val pageOfSwords: String
                get() = "Паж мечей"
            override val pageOfWands: String
                get() = "Паж жезлов"
            override val queenOfCups: String
                get() = "Королева кубков"
            override val queenOfPentacles: String
                get() = "Королева пентаклей"
            override val queenOfSwords: String
                get() = "Королева мечей"
            override val queenOfWands: String
                get() = "Королева жезлов"
            override val cups2: String
                get() = "Двойка кубков"
            override val cups3: String
                get() = "Тройка кубков"
            override val cups4: String
                get() = "Четверка кубков"
            override val cups5: String
                get() = "Пятерка кубков"
            override val cups6: String
                get() = "Шестерка кубков"
            override val cups7: String
                get() = "Семерка кубков"
            override val cups8: String
                get() = "Восьмерка кубков"
            override val cups9: String
                get() = "Девятка кубков"
            override val cups10: String
                get() = "Десятка кубков"
            override val pentacles2: String
                get() = "Двойка пентаклей"
            override val pentacles3: String
                get() = "Тройка пентаклей"
            override val pentacles4: String
                get() = "Четверка пентаклей"
            override val pentacles5: String
                get() = "Пятерка пентаклей"
            override val pentacles6: String
                get() = "Шестерка пентаклей"
            override val pentacles7: String
                get() = "Семерка пентаклей"
            override val pentacles8: String
                get() = "Восьмерка пентаклей"
            override val pentacles9: String
                get() = "Девятка пентаклей"
            override val pentacles10: String
                get() = "Десятка пентаклей"
            override val swords2: String
                get() = "Двойка мечей"
            override val swords3: String
                get() = "Тройка мечей"
            override val swords4: String
                get() = "Четверка мечей"
            override val swords5: String
                get() = "Пятерка мечей"
            override val swords6: String
                get() = "Шестерка мечей"
            override val swords7: String
                get() = "Семерка мечей"
            override val swords8: String
                get() = "Восьмерка мечей"
            override val swords9: String
                get() = "Девятка мечей"
            override val swords10: String
                get() = "Десятка мечей"
            override val wands2: String
                get() = "Двойка жезлов"
            override val wands3: String
                get() = "Тройка жезлов"
            override val wands4: String
                get() = "Четверка жезлов"
            override val wands5: String
                get() = "Пятерка жезлов"
            override val wands6: String
                get() = "Шестерка жезлов"
            override val wands7: String
                get() = "Семерка жезлов"
            override val wands8: String
                get() = "Восьмерка жезлов"
            override val wands9: String
                get() = "Девятка Жезлов"
            override val wands10: String
                get() = "Десятка жезлов"
            override val name: String
                get() = "Младшая колода"
            override val fortuneTeller: String
                get() = "предсказательница София"

        }

        override val olderDeck = RussianOlderDeck()
        override val lowDeck = RussianLowDeck()
        override val fullDeckName: String = "полная колода"

    }
}