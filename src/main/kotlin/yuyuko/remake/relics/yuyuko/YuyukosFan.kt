package yuyuko.remake.relics.yuyuko

import yuyuko.remake.relics.YuyukoRelic

class YuyukosFan : YuyukoRelic(
        relicId,
        RelicTier.STARTER,
        LandingSound.MAGICAL
) {
    override fun onShuffle() = effect()

    override fun makeCopy() = YuyukosFan()

    override fun getUpdatedDescription(): String {
        return DESCRIPTIONS[0]
    }

    override fun effect() {}

    companion object {
        val relicId = "Yuyuko's Fan"
    }
}