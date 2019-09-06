package yuyuko.remake.base.events.yuyuko

import com.megacrit.cardcrawl.cards.CardGroup
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.RebirthYuyukoAction
import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.info.OnShuffleHookInfo
import yuyuko.remake.base.info.Info
import yuyuko.remake.cards.AbstractYuyukoCard

class RebirthYuyukoEvent : AbstractYuyukoEvent() {
    override fun call(info: AbstractHookInfo): Boolean {
        if (info !is OnShuffleHookInfo) return false

        val remainCard = CardGroup(CardGroup.CardGroupType.UNSPECIFIED)
        val removeCard = CardGroup(CardGroup.CardGroupType.UNSPECIFIED)

        for (card in Info.faded.group) {
            if (card is AbstractYuyukoCard && card.isRebirth) removeCard.addToBottom(card)
            else remainCard.addToBottom(card)
        }

        Info.faded.clear()
        for (card in remainCard.group) Info.faded.addToBottom(card)

        for (card in removeCard.group) {
            if (card !is AbstractYuyukoCard) continue
            YuyukoActionManager.add(RebirthYuyukoAction(card))
        }

        return false
    }
}