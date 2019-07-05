package yuyuko.remake.relics.yuyuko

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.cards.yuyuko.Butterfly
import yuyuko.remake.cards.yuyuko.Sakura
import yuyuko.remake.relics.YuyukoRelic

class Yuyukosfan : YuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    override fun onShuffle() {
        AbstractDungeon.actionManager.addToBottom(
                MakeTempCardInDrawPileAction(
                        Sakura(), amount,true, true
                )
        )
        AbstractDungeon.actionManager.addToBottom(
                MakeTempCardInDrawPileAction(
                        Butterfly(), amount,true, true
                )
        )
    }

    override fun makeCopy() = Yuyukosfan()

    override fun getUpdatedDescription(): String {
        return DESCRIPTIONS[0]
    }

    companion object {
        val relicId = "Yuyuko's Fan"

        val amount = 5
    }
}