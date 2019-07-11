package yuyuko.remake.events

import com.megacrit.cardcrawl.cards.AbstractCard
import yuyuko.remake.events.details.DrawCardEvent

object Events {
    fun onDraw(abstractCard: AbstractCard) = DrawCardEvent.onDraw(abstractCard)
}