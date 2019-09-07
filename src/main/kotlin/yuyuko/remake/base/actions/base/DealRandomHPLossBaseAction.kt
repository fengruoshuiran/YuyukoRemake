package yuyuko.remake.base.actions.base

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.utils.Utils
import yuyuko.remake.base.actions.yuyuko.decorator.DealHPLossYuyukoAction

class DealRandomHPLossBaseAction(private val baseDamage: Int) : AbstractBaseAction() {

    override fun update() {
        val target = Utils.getRandomEnemy()

        YuyukoActionManager.add(DealHPLossYuyukoAction(target, baseDamage))

        this.isDone = true
    }
}