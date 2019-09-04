package yuyuko.remake.cards.yuyuko.base

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.GiveAllEnemyConstrictedPowerYuyukoAction
import yuyuko.remake.base.actions.yuyuko.custom.UpgradeAllWithTagYuyukoAction
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch
import yuyuko.remake.cards.YuyukoCard

class FantasyButterfly : YuyukoCard(
        id,
        cost,
        CardType.ATTACK,
        CardRarity.BASIC,
        CardTarget.ALL_ENEMY

) {
    init {
        updateDescription()

        baseMagicNumber = BASE_DEBUFF_NUMBER
    }

    override fun makeCopy(): AbstractCard = FantasyButterfly()

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {
        YuyukoActionManager.add(GiveAllEnemyConstrictedPowerYuyukoAction(baseMagicNumber))
        YuyukoActionManager.add(UpgradeAllWithTagYuyukoAction(UPGRADE_ALL_TAG))
    }

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(UPGRADE_DEBUFF_NUMBER)
    }

    companion object {
        private const val id = "Fantasy Butterfly"
        private const val cost = 1

        private const val BASE_DEBUFF_NUMBER = 1
        private const val UPGRADE_DEBUFF_NUMBER = 1
        private val UPGRADE_ALL_TAG = CardTagsEnumPatch.BUTTERFLY
    }
}