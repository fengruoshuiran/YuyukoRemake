package yuyuko.remake.events.details

import com.megacrit.cardcrawl.actions.common.DrawCardAction
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import org.apache.logging.log4j.LogManager
import yuyuko.remake.actions.HideAction
import yuyuko.remake.cards.YuyukoCard

object DrawCardEvent {
    fun onDraw(card: AbstractCard) {
        if(card is YuyukoCard) {
            if (hideEvent(card)) return
            if (bloomEvent(card)) return
        }
    }

    private fun hideEvent(card: YuyukoCard) = shouldHide(card).also{
        if (it) AbstractDungeon.actionManager.addToTop(
            HideAction(card)
    ) }

    private fun bloomEvent(card: YuyukoCard) = card.isBloom.also {
        if (it) {
            card.bloom()
            AbstractDungeon.actionManager.addToBottom(
                    DrawCardAction(AbstractDungeon.player, 1)
            )
        }
    }

    private fun countDrawPileHideCard() = AbstractDungeon.player.drawPile.group.filter {
        it is YuyukoCard && it.isHide }.count()

    private fun countDrawPileCard() = AbstractDungeon.player.drawPile.group.count()

    private fun shouldHide(card: YuyukoCard) = card.isHide && countDrawPileHideCard() < countDrawPileCard()
}