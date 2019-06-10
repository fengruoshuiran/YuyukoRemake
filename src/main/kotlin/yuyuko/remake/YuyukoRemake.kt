package yuyuko.remake

import basemod.BaseMod
import basemod.interfaces.*
import  com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import yuyuko.remake.customs.Customs

@SpireInitializer
object YuyukoRemake :  EditCharactersSubscriber, EditStringsSubscriber, EditCardsSubscriber, EditRelicsSubscriber{
    @JvmStatic fun initialize() {}

    init {
        BaseMod.subscribe(this)
        Customs.setColor()
    }

    override fun receiveEditCharacters() = Customs.setCharacter()

    override fun receiveEditStrings() = Customs.setStrings()

    override fun receiveEditCards()  = Customs.setCards()

    override fun receiveEditRelics() = Customs.setRelics()
}