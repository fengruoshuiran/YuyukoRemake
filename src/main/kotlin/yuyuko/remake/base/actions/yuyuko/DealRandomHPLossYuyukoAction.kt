package yuyuko.remake.base.actions.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.DealRandomHPLossBaseAction

class DealRandomHPLossYuyukoAction(private val baseDamage: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Deal random HP loss: $baseDamage")
        AbstractDungeon.actionManager.addToBottom(
                DealRandomHPLossBaseAction(baseDamage)
        )
    }
}