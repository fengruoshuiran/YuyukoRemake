package yuyuko.remake.relics

import basemod.abstracts.CustomRelic
import com.megacrit.cardcrawl.helpers.ImageMaster
import yuyuko.remake.base.info.Info

abstract class AbstractYuyukoRelic(
        relicId: String,
        relicTier: RelicTier,
        landingSound: LandingSound

) : CustomRelic(
        getFullRelicId(relicId),
        ImageMaster.loadImage(getImgPath(relicId)),
        relicTier,
        landingSound
) {
    abstract fun effect()

    companion object {
        private const val characterName = Info.Customs.name
        fun getFullRelicId(relicId: String) = "$characterName:$relicId"
        fun getImgPath(relicId: String) = "$characterName/images/relics/$relicId.png"
    }
}