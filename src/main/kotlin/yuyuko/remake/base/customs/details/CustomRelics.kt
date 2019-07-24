package yuyuko.remake.base.customs.details

import basemod.BaseMod
import yuyuko.remake.base.info.Info
import yuyuko.remake.relics.yuyuko.Yuyukosfan

object CustomRelics {
    fun setRelics() {
        BaseMod.addRelicToCustomPool(Yuyukosfan(), Info.Customs.colorType)
    }
}