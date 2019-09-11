package yuyuko.remake.base.powers.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.DealRandomHPLossYuyukoAction
import yuyuko.remake.base.actions.yuyuko.custom.GhostPowerEffectYuyukoAction
import yuyuko.remake.base.actions.yuyuko.custom.GiveRandomEnemyConstrictedPowerYuyukoAction
import yuyuko.remake.base.actions.yuyuko.decorator.ReduceGhostPowerYuyukoAction
import yuyuko.remake.base.powers.AbstractYuyukoPower

class GhostYuyukoPower(stack: Int) : AbstractYuyukoPower(powerId) {
    init {
        owner = AbstractDungeon.player
        type = PowerType.BUFF
        amount = stack
        isTurnBased = false

        updateDescription()
    }

    override fun atEndOfTurn(isPlayer: Boolean) {
        if (!isPlayer) return

        val player = AbstractDungeon.player
        val handCardAmount = player.hand.group.size

        if (handCardAmount > 0) repeat(amount) {
            YuyukoActionManager.add(GhostPowerEffectYuyukoAction())
        }
    }

    override fun updateDescription() {
        description = DESCRIPTIONS[0]
    }

    companion object {
        private const val powerId = "Ghost"
    }
}