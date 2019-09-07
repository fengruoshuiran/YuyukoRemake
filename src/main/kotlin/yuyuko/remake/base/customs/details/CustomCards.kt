package yuyuko.remake.base.customs.details

import basemod.BaseMod
import yuyuko.remake.cards.yuyuko.base.DeathOfGround
import yuyuko.remake.cards.yuyuko.base.DreamySakura
import yuyuko.remake.cards.yuyuko.base.FantasyButterfly
import yuyuko.remake.cards.yuyuko.token.Butterfly
import yuyuko.remake.cards.yuyuko.token.Sakura

object CustomCards {
    fun setCards() {
        BaseMod.addCard(Butterfly())
        BaseMod.addCard(DeathOfGround())
        BaseMod.addCard(DreamySakura())
        BaseMod.addCard(FantasyButterfly())
        BaseMod.addCard(Sakura())
    }
}