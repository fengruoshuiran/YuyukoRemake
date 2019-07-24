package yuyuko.remake.cards.yuyuko

import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.actions.common.DamageAction
import com.megacrit.cardcrawl.cards.DamageInfo
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.cards.YuyukoCard
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch
import yuyuko.remake.base.random.YuyukoRng

class Butterfly : YuyukoCard(
        id,
        cost,
        CardType.STATUS,
        CardRarity.SPECIAL,
        CardTarget.ENEMY
){
    init {
        isHide = true
        isDying = true

        this.tags.add(CardTagsEnumPatch.BUTTERFLY)

        baseDamage = BASE_DAMAGE_NUMBER
    }


    override fun makeCopy() = Butterfly()

    override fun canUse(self: AbstractPlayer?, target: AbstractMonster?) = true

    override fun dying() {
        val self = AbstractDungeon.player
        //select a random monster
        val target = AbstractDungeon.getCurrRoom().monsters.monsters
                .filter { !it.isDeadOrEscaped }.let {
                    it.elementAtOrNull(YuyukoRng.random(it.count()))
                }?: return

        AbstractDungeon.actionManager.addToBottom(
                DamageAction(
                        target,
                        DamageInfo(self, baseDamage, DamageInfo.DamageType.HP_LOSS),
                        AbstractGameAction.AttackEffect.SLASH_DIAGONAL)
        )
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
        val id = "Butterfly"
        val cost = -2

        const val BASE_DAMAGE_NUMBER = 1
        const val UPGRADE_DAMAGE_NUMBER = 1
    }
}