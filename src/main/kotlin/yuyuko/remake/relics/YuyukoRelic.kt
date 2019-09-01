package yuyuko.remake.relics

import basemod.abstracts.CustomRelic
import com.megacrit.cardcrawl.helpers.ImageMaster

abstract class YuyukoRelic(
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
        val characterName = "yuyuko"
        fun getFullRelicId(relicId: String) = "$characterName:$relicId"
        fun getImgPath(relicId: String) = "$characterName/images/relics/$relicId.png"
    }
}