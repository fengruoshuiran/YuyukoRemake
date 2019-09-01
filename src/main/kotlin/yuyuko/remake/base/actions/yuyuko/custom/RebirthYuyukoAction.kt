package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class RebirthYuyukoAction(private val card: AbstractCard): AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Rebirth cards: ${card.name}")
        AbstractDungeon.actionManager.addToTop(
            MakeTempCardInDrawPileAction(
                    card, 1, true, true
            )
        )
    }
}