package yuyuko.remake

import basemod.BaseMod
import basemod.interfaces.*
import  com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.rooms.AbstractRoom
import yuyuko.remake.base.customs.CustomManager
import yuyuko.remake.base.events.EventManager
import yuyuko.remake.base.events.info.OnDrawHookInfo

@SpireInitializer
object YuyukoRemake :
        EditCharactersSubscriber,
        EditStringsSubscriber,
        EditCardsSubscriber,
        EditRelicsSubscriber,
        OnStartBattleSubscriber {
    @JvmStatic fun initialize() {}

    init {
        BaseMod.subscribe(this)
        CustomManager.setColor()
    }

    override fun receiveEditCharacters() = CustomManager.setCharacter()

    override fun receiveEditStrings() = CustomManager.setStrings()

    override fun receiveEditCards()  = CustomManager.setCards()

    override fun receiveEditRelics() = CustomManager.setRelics()

    override fun receiveOnBattleStart(room: AbstractRoom?) { EventManager.initSubscribe() }
}