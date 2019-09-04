package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.cards.CardGroup
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.cards.YuyukoCard

class UpgradeAllWithTagBaseAction(private val tag: AbstractCard.CardTags) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        upgradeCardGroup(player.hand)
        upgradeCardGroup(player.drawPile)
        upgradeCardGroup(player.discardPile)

        this.isDone = true
    }

    fun upgradeCardGroup(cardGroup: CardGroup) {
        for (card in cardGroup.group) {
            if (card is YuyukoCard && card.hasTag(tag)) {
                card.upgrade()
                card.superFlash()
                card.applyPowers()
            }
        }
    }
}