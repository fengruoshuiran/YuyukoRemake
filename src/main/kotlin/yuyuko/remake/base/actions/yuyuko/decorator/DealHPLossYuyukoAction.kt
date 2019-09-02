package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.actions.common.DamageAction
import com.megacrit.cardcrawl.cards.DamageInfo
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class DealHPLossYuyukoAction(
        private val self: AbstractPlayer,
        private val target: AbstractMonster,
        private val baseDamage: Int
) : AbstractYuyukoAction() {
    override fun action() {
        AbstractDungeon.actionManager.addToBottom(
                DamageAction(
                    target,
                     DamageInfo(self, baseDamage, DamageInfo.DamageType.HP_LOSS),
                   AbstractGameAction.AttackEffect.SLASH_DIAGONAL
                )
        )
    }
}