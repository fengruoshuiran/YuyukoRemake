package yuyuko.remake

import basemod.BaseMod
import basemod.interfaces.EditCharactersSubscriber
import basemod.interfaces.EditCardsSubscriber
import  com.evacipated.cardcrawl.modthespire.lib.SpireInitializer

@SpireInitializer
class YuyukoRemake :  EditCharactersSubscriber{
    companion object {
        @JvmStatic
        fun initialize() {
            YuyukoRemake()
        }
    }

    init {
        BaseMod.subscribe(this)
    }

    override fun receiveEditCharacters() {

    }
}