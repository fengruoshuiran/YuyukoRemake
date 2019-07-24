package yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum
import com.megacrit.cardcrawl.cards.AbstractCard

object CardColorEnumPatch {
    @SpireEnum(name = "YUYUKO")
    lateinit var YUYUKO: AbstractCard.CardColor
}