package yuyuko.remake.base.actions.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.DyingBaseAction
import yuyuko.remake.cards.YuyukoCard

class DyingYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Dying cards: ${card.name}")
        AbstractDungeon.actionManager.addToTop(
                DyingBaseAction(card)
        )
    }
}