package yuyuko.remake.patches.com.megacrit.cardcrawl.cards.AbstractCard

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum
import com.megacrit.cardcrawl.cards.AbstractCard

object CardTagsEnumPatch {
    @SpireEnum(name = "SAKURA")
    lateinit var SAKURA: AbstractCard.CardTags
    @SpireEnum(name = "BUTTERFLY")
    lateinit var BUTTERFLY: AbstractCard.CardTags

}