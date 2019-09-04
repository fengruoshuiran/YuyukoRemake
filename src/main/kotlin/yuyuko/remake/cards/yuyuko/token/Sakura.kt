package yuyuko.remake.cards.yuyuko.token

import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.HealYuyukoAction
import yuyuko.remake.cards.YuyukoCard
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch

class Sakura : YuyukoCard(
        id,
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
        magicNumber = BASE_HEAL_NUMBER
    }

    val basename = name

    override fun makeCopy() = Sakura()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) = fading()

    override fun fading() {
        YuyukoActionManager.add(HealYuyukoAction(magicNumber))
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
        private const val id = "Sakura"
        private const val cost = -2

        private const val BASE_HEAL_NUMBER = 1
        private const val UPGRADE_HEAL_NUMBER = 1
    }
}