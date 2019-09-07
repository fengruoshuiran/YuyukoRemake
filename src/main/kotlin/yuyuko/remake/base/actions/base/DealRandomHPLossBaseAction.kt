package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.utils.Utils
import yuyuko.remake.base.actions.yuyuko.decorator.DealHPLossYuyukoAction

class DealRandomHPLossBaseAction(private val baseDamage: Int) : AbstractBaseAction() {

    override fun update() {
        val player = AbstractDungeon.player
        val target = Utils.getRandomEnemy()

        if (target == null) {
            this.isDone = true
            return
        }

        YuyukoActionManager.add(DealHPLossYuyukoAction(player, target, baseDamage))

        this.isDone = true
    }
}