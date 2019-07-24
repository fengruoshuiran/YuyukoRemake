package yuyuko.remake.base.customs

import yuyuko.remake.base.customs.details.CustomRelics
import yuyuko.remake.base.customs.details.CustomCards
import yuyuko.remake.base.customs.details.CustomCharacter
import yuyuko.remake.base.customs.details.CustomColors
import yuyuko.remake.base.customs.details.CustomStrings
import yuyuko.remake.base.info.Info

object CustomManager{
    fun setColor() = CustomColors.setColor(Info.Customs.name, Info.Customs.color, Info.Customs.colorType)

    fun setCharacter() = CustomCharacter.setCharacter(Info.Customs.name, Info.Customs.playerType)

    fun setStrings() = CustomStrings.setStrings(Info.Customs.name, arrayOf(
            "card",
            "event",
            "character",
            "relic"
    ))

    fun setCards() = CustomCards.setCards()

    fun setRelics() = CustomRelics.setRelics()
}