package yuyuko.remake.base.actions.base

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.utils.Utils
import yuyuko.remake.base.actions.yuyuko.decorator.DealHPLossYuyukoAction
import yuyuko.remake.base.actions.yuyuko.decorator.GiveConstrictedPowerYuyukoAction
import yuyuko.remake.base.actions.yuyuko.decorator.ReduceGhostPowerYuyukoAction

class GhostPowerEffectBaseAction() : AbstractBaseAction() {
    override fun update() {
        val target = Utils.getRandomEnemy()

        YuyukoActionManager.add(DealHPLossYuyukoAction(target, 1))
        YuyukoActionManager.add(GiveConstrictedPowerYuyukoAction(target, 1))
        YuyukoActionManager.add(ReduceGhostPowerYuyukoAction(1))

        this.isDone = true
    }
}