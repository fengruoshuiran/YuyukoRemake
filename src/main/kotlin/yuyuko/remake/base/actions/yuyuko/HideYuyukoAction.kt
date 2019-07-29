package yuyuko.remake.base.actions.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.HideBaseAction
import yuyuko.remake.cards.YuyukoCard

class HideYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Hide cards: ${card.name}")
        AbstractDungeon.actionManager.addToBottom(
                HideBaseAction(card)
        )
    }
}