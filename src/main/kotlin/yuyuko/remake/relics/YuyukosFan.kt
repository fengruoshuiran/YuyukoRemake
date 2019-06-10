package yuyuko.remake.relics

import basemod.abstracts.CustomRelic
import com.megacrit.cardcrawl.actions.common.MakeTempCardAtBottomOfDeckAction
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.ImageMaster
import yuyuko.remake.cards.yuyuko.Butterfly
import yuyuko.remake.cards.yuyuko.Sakura

class Yuyukosfan : CustomRelic(
        relicId,
        ImageMaster.loadImage(imgPath),
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
        val characterName = "yuyuko"
        val relicId = "Yuyuko's Fan"
        val imgPath = "$characterName/images/relics/$relicId.png"

        val amount = 5
    }
}