package yuyuko.remake.customs.details

import basemod.BaseMod
import yuyuko.remake.info.YuyukoInfo
import yuyuko.remake.relics.yuyuko.Yuyukosfan

object CustomRelics {
    fun setRelics() {
        BaseMod.addRelicToCustomPool(Yuyukosfan(), YuyukoInfo.Customs.colorType)
    }
}