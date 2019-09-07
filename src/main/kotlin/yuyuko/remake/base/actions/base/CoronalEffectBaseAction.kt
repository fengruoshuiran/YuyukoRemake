package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.GainBlockYuyukoAction
import kotlin.math.ceil

class CoronalEffectBaseAction(private val healAmount: Int) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        val overhealAmount = player.currentHealth + healAmount - player.maxHealth
        if (overhealAmount > 0) {
            YuyukoActionManager.add(GainBlockYuyukoAction(ceil(overhealAmount / 2.0f).toInt()))
        }

        this.isDone = true
    }
}