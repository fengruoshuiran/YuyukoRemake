package yuyuko.remake.events.details

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import org.apache.logging.log4j.LogManager
import yuyuko.remake.actions.HideAction
import yuyuko.remake.cards.YuyukoCard

object DrawCardEvent {
    fun onDraw(card: AbstractCard) {
        if (!hideEvent(card)) bloomEvent(card)
    }

    private fun hideEvent(card: AbstractCard): Boolean {
        if (card is YuyukoCard && card.isHide && shouldHide()) {
            AbstractDungeon.actionManager.addToTop(HideAction(card))
            return true
        }
        return false
    }

    private fun bloomEvent(card: AbstractCard) {
        if (card is YuyukoCard && card.isBloom) {

        }
    }

    private fun countDrawPileHideCard() = AbstractDungeon.player.drawPile.group.filter {
        it is YuyukoCard && it.isHide }.count()

    private fun countDrawPileCard() = AbstractDungeon.player.drawPile.group.count()

    private fun shouldHide() = countDrawPileHideCard() < countDrawPileCard()
}