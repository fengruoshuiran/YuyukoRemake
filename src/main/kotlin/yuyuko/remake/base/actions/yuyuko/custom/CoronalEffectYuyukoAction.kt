package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.CoronalEffectBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class CoronalEffectYuyukoAction(private val healAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Healed! Coronal effect on.")
        AbstractDungeon.actionManager.addToTop(
                CoronalEffectBaseAction(healAmount)
        )
    }
}