package yuyuko.remake.base.actions.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.FadingBaseAction
import yuyuko.remake.cards.YuyukoCard

class FadingYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Fading cards: ${card.name}")
        AbstractDungeon.actionManager.addToBottom(
                FadingBaseAction(card)
        )
    }
}