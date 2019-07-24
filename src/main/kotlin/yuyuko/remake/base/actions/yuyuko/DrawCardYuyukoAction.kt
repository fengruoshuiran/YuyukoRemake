package yuyuko.remake.base.actions.yuyuko

import com.megacrit.cardcrawl.actions.common.DrawCardAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager

class DrawCardYuyukoAction(private val amount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Draw amount: $amount")
        AbstractDungeon.actionManager.addToBottom(
                DrawCardAction(AbstractDungeon.player, 1)
        )
    }
}