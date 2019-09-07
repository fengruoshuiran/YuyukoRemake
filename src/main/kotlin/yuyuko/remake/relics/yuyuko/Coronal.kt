package yuyuko.remake.relics.yuyuko

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.rooms.AbstractRoom
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.custom.CoronalEffectYuyukoAction
import yuyuko.remake.relics.AbstractYuyukoRelic

class Coronal() : AbstractYuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    private var bufferBlockAmount = 0
    private var isBattleStart = false

    override fun atBattleStartPreDraw() {
        isBattleStart = true
    }

    override fun atTurnStart() {
        bufferBlockAmount = AbstractDungeon.player.currentBlock
    }

    override fun atTurnStartPostDraw() {
        AbstractDungeon.player.currentBlock = bufferBlockAmount
    }

    override fun onPlayerHeal(healAmount: Int): Int {
        if (isBattleStart) YuyukoActionManager.add(CoronalEffectYuyukoAction(healAmount))
        return super.onPlayerHeal(healAmount)
    }

    override fun onEnterRoom(room: AbstractRoom?) {
        // TODO: Need more test.
        isBattleStart = false
    }

    override fun makeCopy() = Coronal()

    companion object {
        private const val relicId = "Coronal"
    }
}