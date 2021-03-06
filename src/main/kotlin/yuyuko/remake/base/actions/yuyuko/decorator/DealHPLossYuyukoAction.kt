package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.actions.common.DamageAction
import com.megacrit.cardcrawl.cards.DamageInfo
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class DealHPLossYuyukoAction(
        private val target: AbstractMonster?,
        private val baseDamage: Int
) : AbstractYuyukoAction() {
    override fun action() {
        if (target == null) return

        YuyukoActionManager.logger.info("Deal HP loss: $baseDamage")
        val player = AbstractDungeon.player
        // Update-2019-9-6 In order to prevent target loss, add to top here.
        AbstractDungeon.actionManager.addToTop(
                DamageAction(
                    target,
                     DamageInfo(player, baseDamage, DamageInfo.DamageType.HP_LOSS),
                   AbstractGameAction.AttackEffect.SLASH_DIAGONAL
                )
        )
    }
}