package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.DrawCardYuyukoAction
import yuyuko.remake.cards.YuyukoCard

class FadingBaseAction(private val card: YuyukoCard) : AbstractBaseAction() {
    override fun update() {
        val player = AbstractDungeon.player
        card.fading()
        player.hand.removeCard(card)
        YuyukoActionManager.add(DrawCardYuyukoAction(1))
        this.isDone = true
    }
}