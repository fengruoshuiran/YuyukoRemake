package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.GhostPowerEffectBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class GhostPowerEffectYuyukoAction() : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Ghost power effect")
        AbstractDungeon.actionManager.addToTop(GhostPowerEffectBaseAction())
    }
}