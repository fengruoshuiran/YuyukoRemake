package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.decorator.DrawCardYuyukoAction
import yuyuko.remake.base.info.Info
import yuyuko.remake.cards.AbstractYuyukoCard

class FadingBaseAction(private val card: AbstractYuyukoCard) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        card.fading()
        player.hand.removeCard(card)
        Info.faded.addToBottom(card)
        YuyukoActionManager.add(DrawCardYuyukoAction(1))

        this.isDone = true
    }
}