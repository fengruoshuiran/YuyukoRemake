package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.FadingBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction
import yuyuko.remake.cards.YuyukoCard

class FadingYuyukoAction(private val card: YuyukoCard) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Fading: ${card.name}")
        AbstractDungeon.effectList.add(ShowCardBrieflyEffect(card))
        AbstractDungeon.actionManager.addToTop(
                FadingBaseAction(card)
        )
    }
}