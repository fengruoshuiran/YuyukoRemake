package yuyuko.remake.customs

import yuyuko.remake.customs.details.CustomRelics
import yuyuko.remake.customs.details.CustomCards
import yuyuko.remake.customs.details.CustomCharacter
import yuyuko.remake.customs.details.CustomColors
import yuyuko.remake.customs.details.CustomStrings
import yuyuko.remake.info.YuyukoInfo

object Customs{
    fun setColor() = CustomColors.setColor(YuyukoInfo.Customs.name, YuyukoInfo.Customs.color, YuyukoInfo.Customs.colorType)

    fun setCharacter() = CustomCharacter.setCharacter(YuyukoInfo.Customs.name, YuyukoInfo.Customs.playerType)

    fun setStrings() = CustomStrings.setStrings(YuyukoInfo.Customs.name, arrayOf(
            "card",
            "event",
            "character",
            "relic"
    ))

    fun setCards() = CustomCards.setCards()

    fun setRelics() = CustomRelics.setRelics()
}