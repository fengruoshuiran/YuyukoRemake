package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.HiddenBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.cards.YuyukoCard

class HiddenYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Hidden: ${card.name}")
        AbstractDungeon.actionManager.addToTop(
                HiddenBaseAction(card)
        )
    }
}