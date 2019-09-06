package yuyuko.remake.base.powers.yuyuko

import com.megacrit.cardcrawl.cards.DamageInfo
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.powers.AbstractYuyukoPower

class TransparentYuyukoPower(private val stack: Int) : AbstractYuyukoPower(powerId) {
    init {
        owner = AbstractDungeon.player
        type = PowerType.BUFF
        amount = stack
        isTurnBased = false
        updateDescription()
    }

    override fun atDamageReceive(damage: Float, damageType: DamageInfo.DamageType?): Float {
        return damage - amount
    }

    override fun updateDescription() {
        description = DESCRIPTIONS[0]
    }

    companion object {
        private const val powerId = "Transparent"
    }
}