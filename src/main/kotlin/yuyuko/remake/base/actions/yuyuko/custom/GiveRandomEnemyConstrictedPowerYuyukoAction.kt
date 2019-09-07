package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.GiveRandomEnemyConstrictedPowerBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class GiveRandomEnemyConstrictedPowerYuyukoAction(private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Give random enemy constricted power: $powerAmount")

        AbstractDungeon.actionManager.addToTop(
                GiveRandomEnemyConstrictedPowerBaseAction(powerAmount)
        )
    }
}