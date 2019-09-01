package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.cards.AbstractCard
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class RebirthYuyukoAction(private val card: AbstractCard): AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Rebirth cards: ${card.name}")
        YuyukoActionManager.add(AddCardToDrawPileYuyukoAction(card))
    }
}