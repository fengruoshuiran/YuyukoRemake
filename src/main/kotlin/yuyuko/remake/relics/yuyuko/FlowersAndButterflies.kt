package yuyuko.remake.relics.yuyuko

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.AddCardToDrawPileYuyukoAction
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
        repeat(5) { YuyukoActionManager.add(AddCardToDrawPileYuyukoAction(Sakura())) }
        repeat(5) { YuyukoActionManager.add(AddCardToDrawPileYuyukoAction(Butterfly())) }
    }

    companion object {
        val relicId = "Flowers and Butterflies"

        val amount = 5
    }
}