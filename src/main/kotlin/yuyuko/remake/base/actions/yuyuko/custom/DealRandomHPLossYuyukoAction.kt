package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.DealRandomHPLossBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class DealRandomHPLossYuyukoAction(private val baseDamage: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Deal random HP loss: $baseDamage")
        AbstractDungeon.actionManager.addToTop(
                DealRandomHPLossBaseAction(baseDamage)
        )
    }
}