package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.AddCardToDrawPileBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class AddCardToDrawPileYuyukoAction(private val card: AbstractCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Add to draw pile: ${card.name}")
        AbstractDungeon.actionManager.addToBottom(
            AddCardToDrawPileBaseAction(card)
        )
    }
}