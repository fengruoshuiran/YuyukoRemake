package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.base.powers.yuyuko.TransparentYuyukoPower

class GainTransparentPowerYuyukoAction(private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Gain Transparent power: $powerAmount")

        val player = AbstractDungeon.player
        // Update-2019-9-6 In order to prevent target loss, add damage action to top here.
        AbstractDungeon.actionManager.addToTop(
                ApplyPowerAction(
                        player, player,
                        TransparentYuyukoPower(powerAmount),
                        powerAmount
                )
        )
    }
}