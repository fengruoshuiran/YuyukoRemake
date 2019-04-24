package yuyuko.remake.customs

import com.megacrit.cardcrawl.cards.AbstractCard
import yuyuko.remake.customs.CustomColors

class Customs{
    fun setColor(
            colorType: AbstractCard.CardColor,
            name: String,
            r: Float,
            g: Float,
            b: Float,
            a: Float
    ) = CustomColors.setColor(colorType, name, r, g, b, a)


}