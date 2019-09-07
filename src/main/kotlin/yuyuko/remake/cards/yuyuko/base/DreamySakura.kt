package yuyuko.remake.cards.yuyuko.base

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.UpgradeAllWithTagYuyukoAction
import yuyuko.remake.base.actions.yuyuko.decorator.GainTransparentPowerYuyukoAction
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch
import yuyuko.remake.cards.AbstractYuyukoCard

class DreamySakura() : AbstractYuyukoCard(
        cardId,
        cost,
        CardType.SKILL,
        CardRarity.BASIC,
        CardTarget.SELF
) {
    init {
        updateDescription()

        baseMagicNumber = BASE_BUFF_NUMBER
    }

    override fun makeCopy() = DreamySakura()

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {
        YuyukoActionManager.add(GainTransparentPowerYuyukoAction(baseMagicNumber))
        YuyukoActionManager.add(UpgradeAllWithTagYuyukoAction(UPGRADE_ALL_TAG))
    }

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(UPGRADE_BUFF_NUMBER)
    }
    companion object {
        private const val cardId = "Dreamy Sakura"
        private const val cost = 1

        private const val BASE_BUFF_NUMBER = 1
        private const val UPGRADE_BUFF_NUMBER = 1
        private val UPGRADE_ALL_TAG = CardTagsEnumPatch.SAKURA
    }
}