package yuyuko.remake.base.events.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.HiddenYuyukoAction
import yuyuko.remake.cards.YuyukoCard
import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.info.OnDrawHookInfo

class HiddenYuyukoEvent() : AbstractYuyukoEvent() {
    override fun call(info: AbstractHookInfo): Boolean {
        if (info !is OnDrawHookInfo) return false
        if (info.card !is YuyukoCard) return false
        if (!shouldHide(info.card)) return false
        YuyukoActionManager.add(HiddenYuyukoAction(info.card))
        return true
    }

    private fun countDrawPileHideCard() = AbstractDungeon.player.drawPile.group
            .filter { it is YuyukoCard && it.isHidden }.count()

    private fun countDrawPileCard() = AbstractDungeon.player.drawPile.group.count()

    private fun shouldHide(card: YuyukoCard) = card.isHidden && countDrawPileHideCard() < countDrawPileCard()
}