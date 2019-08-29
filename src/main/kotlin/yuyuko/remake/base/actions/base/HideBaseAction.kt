package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.DrawCardYuyukoAction
import yuyuko.remake.cards.YuyukoCard

class HideBaseAction(private val card: YuyukoCard) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        player.hand.removeCard(card)
        player.drawPile.addToBottom(card)
        YuyukoActionManager.add(DrawCardYuyukoAction(1))

        this.isDone = true
    }
}