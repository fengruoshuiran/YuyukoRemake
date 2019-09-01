package yuyuko.remake.relics.yuyuko

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.cards.yuyuko.Butterfly
import yuyuko.remake.cards.yuyuko.Sakura
import yuyuko.remake.relics.YuyukoRelic

class FlowersAndButterflies() : YuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    override fun onShuffle() = effect()

    override fun atBattleStartPreDraw() = effect()

    override fun makeCopy() = FlowersAndButterflies()

    override fun getUpdatedDescription(): String {
        return DESCRIPTIONS[0]
    }

    override fun effect() {
        AbstractDungeon.actionManager.addToBottom(
                MakeTempCardInDrawPileAction(
                        Sakura(), 1,true, true
                )
        )
        AbstractDungeon.actionManager.addToBottom(
                MakeTempCardInDrawPileAction(
                        Butterfly(), amount,true, true
                )
        )
    }

    companion object {
        val relicId = "Flowers and Butterflies"

        val amount = 5
    }
}