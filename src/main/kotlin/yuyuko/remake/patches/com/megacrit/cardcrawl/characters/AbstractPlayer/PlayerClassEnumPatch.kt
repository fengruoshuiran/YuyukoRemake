package yuyuko.remake.patches.com.megacrit.cardcrawl.characters.AbstractPlayer

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum
import com.megacrit.cardcrawl.characters.AbstractPlayer

object PlayerClassEnumPatch {
    @SpireEnum
    var YUYUKO: AbstractPlayer.PlayerClass? = null
}