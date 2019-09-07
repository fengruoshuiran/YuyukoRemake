package yuyuko.remake.base.actions.base

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.utils.Utils
import yuyuko.remake.base.actions.yuyuko.decorator.GiveConstrictedPowerYuyukoAction

class GiveRandomEnemyConstrictedPowerBaseAction(private val powerAmount: Int) : AbstractBaseAction() {
    override fun update() {
        val target = Utils.getRandomEnemy()

        YuyukoActionManager.add(GiveConstrictedPowerYuyukoAction(target, powerAmount))

        this.isDone = true
    }
}