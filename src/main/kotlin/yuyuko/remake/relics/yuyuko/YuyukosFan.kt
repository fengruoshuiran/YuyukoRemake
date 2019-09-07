package yuyuko.remake.relics.yuyuko

import com.megacrit.cardcrawl.cards.AbstractCard
import yuyuko.remake.base.events.EventManager
import yuyuko.remake.base.events.info.OnDrawHookInfo
import yuyuko.remake.base.events.info.OnShuffleHookInfo
import yuyuko.remake.base.info.Info
import yuyuko.remake.relics.AbstractYuyukoRelic

class YuyukosFan : AbstractYuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    override fun onCardDraw(card: AbstractCard) = EventManager.call(OnDrawHookInfo(card))

    override fun onShuffle() = EventManager.call(OnShuffleHookInfo())

    override fun atBattleStartPreDraw() = Info.faded.clear()

    override fun makeCopy() = YuyukosFan()

    companion object {
        val relicId = "Yuyuko's Fan"
    }
}