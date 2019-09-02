package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.DealHPLossYuyukoAction
import yuyuko.remake.base.random.YuyukoRng

class DealRandomHPLossBaseAction(private val baseDamage: Int) : AbstractBaseAction() {

    override fun update() {
        val self = AbstractDungeon.player
        //select a random monster
        val target = AbstractDungeon.getCurrRoom().monsters.monsters
                .filter { !it.isDeadOrEscaped }.let {
                    it.elementAtOrNull(YuyukoRng.random(it.count() - 1))
                }

        if (target == null) {
            this.isDone = true
            return
        }

        YuyukoActionManager.add(DealHPLossYuyukoAction(self, target, baseDamage))

        this.isDone = true
    }
}