package yuyuko.remake.base.customs

import yuyuko.remake.base.customs.details.*
import yuyuko.remake.base.info.Info

object CustomManager{
    fun setColor() = CustomColors.setColor(Info.Customs.name, Info.Customs.color, Info.Customs.colorType)

    fun setCharacter() = CustomCharacter.setCharacter(Info.Customs.name, Info.Customs.playerType)

    fun setCards() = CustomCards.setCards()

    fun setRelics() = CustomRelics.setRelics()

    fun setKeywords() = CustomKeywords.setKeywords()

    fun setStrings() = CustomStrings.setStrings(Info.Customs.name, arrayOf(
            "card",
            "event",
            "character",
            "relic",
            "keyword",
            "power"
    ))
}