package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.HideBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.cards.YuyukoCard

class HideYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Hide cards: ${card.name}")
        AbstractDungeon.actionManager.addToTop(
                HideBaseAction(card)
        )
    }
}