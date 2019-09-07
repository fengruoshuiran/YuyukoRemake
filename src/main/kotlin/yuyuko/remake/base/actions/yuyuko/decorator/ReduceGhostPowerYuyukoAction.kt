package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.ReducePowerAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class ReduceGhostPowerYuyukoAction(private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Reduce ghost power: $powerAmount")

        val player = AbstractDungeon.player
        // Update-2019-9-7 To show better vfx, add to top here.
        AbstractDungeon.actionManager.addToTop(
                ReducePowerAction(
                        player, player, "yuyuko:Ghost", powerAmount
                )
        )
    }
}