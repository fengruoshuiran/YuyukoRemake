package yuyuko.remake.cards.yuyuko.base

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.DealHPLossYuyukoAction
import yuyuko.remake.base.actions.yuyuko.decorator.GainGhostPowerYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard

class DeathOfGround() : AbstractYuyukoCard(
        cardId,
        cost,
        CardType.ATTACK,
        CardRarity.BASIC,
        CardTarget.ENEMY
) {
    init {
        updateDescription()

        baseDamage = BASE_DAMAGE_NUMBER
        baseMagicNumber = BASE_BUFF_NUMBER
    }

    override fun makeCopy(): AbstractCard  = DeathOfGround()

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {
        YuyukoActionManager.add(DealHPLossYuyukoAction(target, baseDamage))
        YuyukoActionManager.add(GainGhostPowerYuyukoAction(baseMagicNumber))
    }

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(UPGRADE_BUFF_NUMBER)
    }

    companion object {
        private const val cardId = "Death of Ground"
        private const val cost = 0

        private const val BASE_DAMAGE_NUMBER = 4
        private const val BASE_BUFF_NUMBER = 1
        private const val UPGRADE_BUFF_NUMBER = 1
    }
}