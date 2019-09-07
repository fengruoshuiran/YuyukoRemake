package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.base.powers.yuyuko.GhostYuyukoPower

class GainGhostPowerYuyukoAction(private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Gain Ghost power: $powerAmount")

        val player = AbstractDungeon.player
        AbstractDungeon.actionManager.addToBottom(
                ApplyPowerAction(
                        player, player,
                        GhostYuyukoPower(powerAmount),
                        powerAmount
                )
        )
    }
}