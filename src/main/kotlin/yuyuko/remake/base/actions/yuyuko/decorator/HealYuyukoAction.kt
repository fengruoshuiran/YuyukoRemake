package yuyuko.remake.base.actions.yuyuko.decorator

import com.megacrit.cardcrawl.actions.common.HealAction
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class HealYuyukoAction(private val amount: Int) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Heal: $amount")
        val self = AbstractDungeon.player
        AbstractDungeon.actionManager.addToBottom(
                HealAction(self, self, amount)
        )
    }
}