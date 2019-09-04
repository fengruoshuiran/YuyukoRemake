package yuyuko.remake.base.actions.yuyuko.custom

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import yuyuko.remake.base.actions.YuyukoActionManager
import yuyuko.remake.base.actions.base.UpgradeAllWithTagBaseAction
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

class UpgradeAllWithTagYuyukoAction(private val tag: AbstractCard.CardTags) : AbstractYuyukoAction() {
    override fun action() {
        YuyukoActionManager.logger.info("Upgrade all with tag: ${tag.name}")
        AbstractDungeon.actionManager.addToTop(UpgradeAllWithTagBaseAction(tag))
    }
}