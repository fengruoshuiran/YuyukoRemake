package yuyuko.remake.relics.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.CoronalEffectYuyukoAction
import yuyuko.remake.relics.AbstractYuyukoRelic

class Coronal() : AbstractYuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    private var bufferBlockAmount = 0

    override fun atTurnStart() {
        bufferBlockAmount = AbstractDungeon.player.currentBlock
    }

    override fun atTurnStartPostDraw() {
        AbstractDungeon.player.currentBlock = bufferBlockAmount
    }

    override fun onPlayerHeal(healAmount: Int): Int {
        YuyukoActionManager.add(CoronalEffectYuyukoAction(healAmount))
        return super.onPlayerHeal(healAmount)
    }

    override fun makeCopy() = Coronal()

    companion object {
        private const val relicId = "Coronal"
    }
}