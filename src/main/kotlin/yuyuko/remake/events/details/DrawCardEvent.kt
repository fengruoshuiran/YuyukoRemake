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
            bloomEvent(card)
        }
    }

    private fun hideEvent(card: YuyukoCard): Boolean {
        if (shouldHide(card)) AbstractDungeon.actionManager.addToTop(
                HideAction(card)
        )
        return shouldHide(card)
    }

    private fun bloomEvent(card: YuyukoCard) {
        if (card.isBloom) {
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