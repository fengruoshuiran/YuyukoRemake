package yuyuko.remake.events.details

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import org.apache.logging.log4j.LogManager
import yuyuko.remake.actions.HideAction
import yuyuko.remake.cards.YuyukoCard

object DrawCardEvent {

    var logger = LogManager.getLogger(DrawCardEvent.javaClass.name)

    fun onDraw(card: AbstractCard) {
        if (card is YuyukoCard) {
            if (card.isHide && countDrawPileHideCard() < countDrawPileCard()) {
                logger.info("HideAction")
                AbstractDungeon.actionManager.addToTop(HideAction(card))
            }
        }
    }

    fun countDrawPileHideCard() = AbstractDungeon.player.drawPile.group.filter {
        it is YuyukoCard &&  it.isHide }.count()
    fun countDrawPileCard() = AbstractDungeon.player.drawPile.group.count()
}