package yuyuko.remake.patches.com.megacrit.cardcrawl.helpers.CardLibrary

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum
import com.megacrit.cardcrawl.helpers.CardLibrary

object LibraryTypeEnumPatch {
    @SpireEnum
    var YUYUKO: CardLibrary.LibraryType? = null
}