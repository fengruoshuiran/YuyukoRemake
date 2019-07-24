package yuyuko.remake.base.events.yuyuko

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.DyingYuyukoAction
import yuyuko.remake.cards.YuyukoCard
import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.info.OnDrawHookInfo

class DyingYuyukoEvent : AbstractYuyukoEvent() {
    override fun call(info: AbstractHookInfo): Boolean {
        if (info !is OnDrawHookInfo) return false
        if (info.card !is YuyukoCard) return false
        if (!shouldDying(info.card)) return false
        YuyukoActionManager.add(DyingYuyukoAction(info.card))
        return true
    }

    private fun shouldDying(card: YuyukoCard) = card.isDying
}