package yuyuko.remake.cards.yuyuko.token

import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.HealYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch

class Sakura : AbstractYuyukoCard(
        cardId,
        cost,
        CardType.SKILL,
        CardRarity.SPECIAL,
        CardTarget.SELF
) {
    init {
        isHidden = true
        isFading = true

        tags.add(CardTagsEnumPatch.SAKURA)

        updateDescription()

        baseMagicNumber = BASE_HEAL_NUMBER
    }

    private val basename = name

    override fun makeCopy() = Sakura()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) = fading()

    override fun fading() {
        YuyukoActionManager.add(HealYuyukoAction(baseMagicNumber))
    }

    override fun canUpgrade() = true

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(UPGRADE_HEAL_NUMBER)
    }

    override fun upgradeName() {
        ++timesUpgraded
        upgraded = true
        name ="$basename+$timesUpgraded"
        initializeTitle()
    }

    companion object {
        private const val cardId = "Sakura"
        private const val cost = -2

        private const val BASE_HEAL_NUMBER = 1
        private const val UPGRADE_HEAL_NUMBER = 1
    }
}