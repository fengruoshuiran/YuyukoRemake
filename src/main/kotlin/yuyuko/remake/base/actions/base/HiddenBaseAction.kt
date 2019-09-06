package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.DrawCardYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard

class HiddenBaseAction(private val card: AbstractYuyukoCard) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        player.hand.moveToBottomOfDeck(card)
        YuyukoActionManager.add(DrawCardYuyukoAction(1))

        this.isDone = true
    }
}