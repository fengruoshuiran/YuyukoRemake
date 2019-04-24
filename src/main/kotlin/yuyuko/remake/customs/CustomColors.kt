package yuyuko.remake.customs

import com.megacrit.cardcrawl.cards.AbstractCard
import basemod.BaseMod
import com.badlogic.gdx.graphics.Color

object CustomColors {
    fun setColor(
            colorType: AbstractCard.CardColor,
            name: String,
            r: Float,
            g: Float,
            b: Float,
            a: Float
    ) {
        val customColor = Color(r, g, b, a)
        val rootImagesPath = "$name/images/"

        BaseMod.addColor(colorType,
                customColor, customColor, customColor, customColor, customColor, customColor, customColor,
                "${rootImagesPath}backgrounds/512/attack.png",
                "${rootImagesPath}backgrounds/512/skill.png",
                "${rootImagesPath}backgrounds/512/power.png",
                "${rootImagesPath}orbs/512/orb.png",
                "${rootImagesPath}backgrounds/1024/attack.png",
                "${rootImagesPath}backgrounds/1024/skill.png",
                "${rootImagesPath}backgrounds/1024/power.png",
                "${rootImagesPath}orbs/1024/orb.png")
    }
}