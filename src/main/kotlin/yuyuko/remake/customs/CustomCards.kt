package yuyuko.remake.customs

import basemod.BaseMod
import yuyuko.remake.cards.yuyuko.*

object CustomCards {
    fun setCards() {
        BaseMod.addCard(Sakura())
        BaseMod.addCard(Butterfly())
    }
}