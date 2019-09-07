package yuyuko.remake.relics.yuyuko

import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.AddCardToDrawPileYuyukoAction
import yuyuko.remake.cards.yuyuko.token.Butterfly
import yuyuko.remake.cards.yuyuko.token.Sakura
import yuyuko.remake.relics.AbstractYuyukoRelic

class FlowersAndButterflies() : AbstractYuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    override fun onShuffle() = effect()

    override fun atBattleStartPreDraw() = effect()

    override fun makeCopy() = FlowersAndButterflies()

    override fun effect() {
        repeat(5) { YuyukoActionManager.add(AddCardToDrawPileYuyukoAction(Sakura())) }
        repeat(5) { YuyukoActionManager.add(AddCardToDrawPileYuyukoAction(Butterfly())) }
    }

    companion object {
        val relicId = "Flowers and Butterflies"

        val amount = 5
    }
}