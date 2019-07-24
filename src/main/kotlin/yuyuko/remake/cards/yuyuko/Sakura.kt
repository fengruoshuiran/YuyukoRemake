package yuyuko.remake.cards.yuyuko

import com.megacrit.cardcrawl.actions.common.HealAction
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
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
        isHide = false
        isDying = false

        this.tags.add(CardTagsEnumPatch.SAKURA)

        baseMagicNumber = baseHealNumber
        magicNumber = baseHealNumber
    }


    override fun makeCopy() = Sakura()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {
        AbstractDungeon.actionManager.addToBottom(
            HealAction(self, self, magicNumber)
        )
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