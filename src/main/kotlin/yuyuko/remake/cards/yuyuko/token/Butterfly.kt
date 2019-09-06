package yuyuko.remake.cards.yuyuko.token

import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.DealRandomHPLossYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch

class Butterfly : AbstractYuyukoCard(
        cardId,
        cost,
        CardType.ATTACK,
        CardRarity.SPECIAL,
        CardTarget.ENEMY
){
    init {
        isHidden = true
        isFading = true

        tags.add(CardTagsEnumPatch.BUTTERFLY)

        updateDescription()

        baseDamage = BASE_DAMAGE_NUMBER
    }
    private val baseName = name

    override fun makeCopy() = Butterfly()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) = fading()

    override fun fading() {
        YuyukoActionManager.add(DealRandomHPLossYuyukoAction(baseDamage))
    }

    override fun canUpgrade() = true

    override fun upgrade() {
        upgradeName()
        upgradeDamage(UPGRADE_DAMAGE_NUMBER)
    }

    override fun upgradeName() {
        ++timesUpgraded
        upgraded = true
        name ="$baseName+$timesUpgraded"
        initializeTitle()
    }

    companion object {
        private const val cardId = "Butterfly"
        private const val cost = -2

        private const val BASE_DAMAGE_NUMBER = 1
        private const val UPGRADE_DAMAGE_NUMBER = 1
    }
}