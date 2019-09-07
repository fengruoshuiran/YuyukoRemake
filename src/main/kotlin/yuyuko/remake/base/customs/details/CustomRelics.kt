package yuyuko.remake.base.customs.details

import basemod.BaseMod
import yuyuko.remake.base.info.Info
import yuyuko.remake.relics.yuyuko.Coronal
import yuyuko.remake.relics.yuyuko.FlowersAndButterflies
import yuyuko.remake.relics.yuyuko.YuyukosFan

object CustomRelics {
    fun setRelics() {
        BaseMod.addRelicToCustomPool(Coronal(), Info.Customs.colorType)
        BaseMod.addRelicToCustomPool(FlowersAndButterflies(), Info.Customs.colorType)
        BaseMod.addRelicToCustomPool(YuyukosFan(), Info.Customs.colorType)
    }
}