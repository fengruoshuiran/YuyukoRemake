package yuyuko.remake.customs

import basemod.BaseMod
import yuyuko.remake.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardColorEnumPatch
import yuyuko.remake.relics.Yuyukosfan

object CustomRelics {
    fun setRelics() {
        BaseMod.addRelicToCustomPool(Yuyukosfan(), CardColorEnumPatch.YUYUKO)
    }
}