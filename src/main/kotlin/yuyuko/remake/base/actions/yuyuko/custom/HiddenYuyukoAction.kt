package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.HiddenBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard

class HiddenYuyukoAction(private val card: AbstractYuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Hidden: ${card.name}")
        AbstractDungeon.actionManager.addToTop(
                HiddenBaseAction(card)
        )
    }
}