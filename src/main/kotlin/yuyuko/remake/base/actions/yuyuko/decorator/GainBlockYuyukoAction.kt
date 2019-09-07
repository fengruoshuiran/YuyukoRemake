package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.GainBlockAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class GainBlockYuyukoAction(private val blockAmount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Gain block: $blockAmount")

        // Update-2019-9-7 Add to top for better VFX.
        val player = AbstractDungeon.player
        AbstractDungeon.actionManager.addToTop(
                GainBlockAction(player, player, blockAmount)
        )
    }
}