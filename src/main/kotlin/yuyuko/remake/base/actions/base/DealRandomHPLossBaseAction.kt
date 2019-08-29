package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.actions.common.DamageAction
import com.megacrit.cardcrawl.cards.DamageInfo
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
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

        AbstractDungeon.actionManager.addToTop(
                DamageAction(
                        target,
                        DamageInfo(self, baseDamage, DamageInfo.DamageType.HP_LOSS),
                        AttackEffect.SLASH_DIAGONAL)
        )

        this.isDone = true
    }
}