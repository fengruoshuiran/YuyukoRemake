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
        CardType.STATUS,
        CardRarity.SPECIAL,
        CardTarget.SELF
) {
    init {
        isHidden = false
        isFading = false
        exhaust = true

        tags.add(CardTagsEnumPatch.SAKURA)

        updateDescription()

        baseMagicNumber = baseHealNumber
        magicNumber = baseHealNumber
    }


    override fun makeCopy() = Sakura()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) = fading()

    override fun fading() {
        YuyukoActionManager.add(HealYuyukoAction(magicNumber))
    }

    override fun canUpgrade() = true

    override fun upgrade() {
        upgradeName()
        upgradeMagicNumber(upgradeHealNumber)
    }

    override fun upgradeName() {
        ++timesUpgraded
        this.upgraded = true
        this.name ="$name+$timesUpgraded"
        this.initializeTitle()
    }

    companion object {
        val id = "Sakura"
        val cost = -2

        var baseHealNumber = 1
        var upgradeHealNumber = 1
    }
}