package yuyuko.remake.base.events.info

import com.megacrit.cardcrawl.cards.AbstractCard

class OnDrawHookInfo(val card: AbstractCard) : AbstractHookInfo() {
    override val hookName = "OnDraw"
}