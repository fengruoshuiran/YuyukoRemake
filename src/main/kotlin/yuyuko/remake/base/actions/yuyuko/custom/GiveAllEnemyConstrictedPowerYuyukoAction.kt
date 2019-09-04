package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.GiveAllEnemyConstrictedPowerBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class GiveAllEnemyConstrictedPowerYuyukoAction(private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Give all enemy constricted power: $powerAmount")
        AbstractDungeon.actionManager.addToTop(
                GiveAllEnemyConstrictedPowerBaseAction(powerAmount)
        )
    }
}