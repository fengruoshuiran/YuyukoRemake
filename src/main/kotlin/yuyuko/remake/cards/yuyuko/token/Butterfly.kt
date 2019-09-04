package yuyuko.remake.cards.yuyuko.token

import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.DealRandomHPLossYuyukoAction
import yuyuko.remake.cards.YuyukoCard
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch

class Butterfly : YuyukoCard(
        id,
        cost,
        CardType.ATTACK,
        CardRarity.SPECIAL,
        CardTarget.ENEMY
){
    init {
        isHidden = true
        isFading = true
        isRebirth = true

        tags.add(CardTagsEnumPatch.BUTTERFLY)

        updateDescription()

        baseDamage = BASE_DAMAGE_NUMBER
    }


    override fun makeCopy() = Butterfly()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun fading() {
        YuyukoActionManager.add(DealRandomHPLossYuyukoAction(baseDamage))
    }

    override fun canUpgrade() = true

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(UPGRADE_DAMAGE_NUMBER)
    }

    override fun upgradeName() {
        ++timesUpgraded
        this.upgraded = true
        this.name ="$name+$timesUpgraded"
        this.initializeTitle()
    }

    companion object {
        private const val id = "Butterfly"
        private const val cost = -2

        private const val BASE_DAMAGE_NUMBER = 1
        private const val UPGRADE_DAMAGE_NUMBER = 1
    }
}