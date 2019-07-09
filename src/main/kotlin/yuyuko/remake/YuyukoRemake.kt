package yuyuko.remake

import basemod.BaseMod
import basemod.interfaces.*
import  com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.cards.AbstractCard
import yuyuko.remake.customs.Customs
import yuyuko.remake.events.Events

@SpireInitializer
object YuyukoRemake :
        EditCharactersSubscriber,
        EditStringsSubscriber,
        EditCardsSubscriber,
        EditRelicsSubscriber,
        PostDrawSubscriber {
    @JvmStatic fun initialize() {}

    init {
        BaseMod.subscribe(this)
        Customs.setColor()
    }

    override fun receiveEditCharacters() = Customs.setCharacter()

    override fun receiveEditStrings() = Customs.setStrings()

    override fun receiveEditCards()  = Customs.setCards()

    override fun receiveEditRelics() = Customs.setRelics()

    override fun receivePostDraw(abstractCard: AbstractCard) = Events.onDraw(abstractCard)
}