package yuyuko.remake.base.powers

import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.helpers.ImageMaster
import com.megacrit.cardcrawl.powers.AbstractPower
import yuyuko.remake.base.info.Info

abstract class AbstractYuyukoPower(private val powerId: String) : AbstractPower() {
    init {
        ID = getFullId(powerId)
        name = getName(powerId)
        DESCRIPTIONS = getDescriptions(powerId)
        img = ImageMaster.loadImage(getImgPath(powerId))
    }

    companion object {
        private val characterName = Info.Customs.name
        private fun getFullId(id: String) = "$characterName:$id"
        private fun getPowerString(id: String) = CardCrawlGame.languagePack.getPowerStrings(getFullId(id))
        private fun getName(id: String) = getPowerString(id).NAME
        private fun getDescriptions(id: String) = getPowerString(id).DESCRIPTIONS
        private fun getImgPath(id: String) = "$characterName/images/powers/$id.png"
    }
}