package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.GiveConstrictedPowerYuyukoAction

class GiveAllEnemyConstrictedPowerBaseAction(private val powerAmount: Int) : AbstractBaseAction() {
    override fun update() {
        val targets = AbstractDungeon.getCurrRoom().monsters.monsters.filter { !it.isDeadOrEscaped }

        for (target in targets) {
            YuyukoActionManager.add(GiveConstrictedPowerYuyukoAction(target, powerAmount))
        }

        this.isDone = true
    }
}