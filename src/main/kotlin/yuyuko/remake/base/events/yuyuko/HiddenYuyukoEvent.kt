package yuyuko.remake.base.events.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.HiddenYuyukoAction
import yuyuko.remake.cards.AbstractYuyukoCard
import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.info.OnDrawHookInfo

class HiddenYuyukoEvent() : AbstractYuyukoEvent() {
    override fun call(info: AbstractHookInfo): Boolean {
        if (info !is OnDrawHookInfo) return false
        if (info.card !is AbstractYuyukoCard) return false
        if (!shouldHide(info.card)) return false
        YuyukoActionManager.add(HiddenYuyukoAction(info.card))
        return true
    }

    private fun countDrawPileHideCard() = AbstractDungeon.player.drawPile.group
            .filter { it is AbstractYuyukoCard && it.isHidden }.count()

    private fun countDrawPileCard() = AbstractDungeon.player.drawPile.group.count()

    private fun shouldHide(card: AbstractYuyukoCard) = card.isHidden && countDrawPileHideCard() < countDrawPileCard()
}