package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
import com.megacrit.cardcrawl.powers.ConstrictedPower
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class GiveConstrictedPowerYuyukoAction(
        private val target: AbstractMonster?,
        private val powerAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        if (target == null) return

        val player = AbstractDungeon.player

        YuyukoActionManager.logger.info("Give $powerAmount constricted to: ${target.name}")
        // Update-2019-9-7 In order to prevent target loss, add to top here.
        AbstractDungeon.actionManager.addToTop(
                ApplyPowerAction(
                        target, player,
                        ConstrictedPower(target, player, powerAmount),
                        powerAmount
                )
        )
    }
}