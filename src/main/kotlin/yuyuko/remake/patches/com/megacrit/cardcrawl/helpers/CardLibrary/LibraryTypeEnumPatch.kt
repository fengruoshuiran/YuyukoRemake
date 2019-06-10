package yuyuko.remake.patches.com.megacrit.cardcrawl.helpers.CardLibrary

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum
import com.megacrit.cardcrawl.helpers.CardLibrary

object LibraryTypeEnumPatch {
    @SpireEnum(name = "YUYUKO")
    lateinit var YUYUKO: CardLibrary.LibraryType
}