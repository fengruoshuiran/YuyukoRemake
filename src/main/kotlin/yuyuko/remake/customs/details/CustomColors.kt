package yuyuko.remake.customs.details

import com.megacrit.cardcrawl.cards.AbstractCard
import basemod.BaseMod
import com.badlogic.gdx.graphics.Color

internal object CustomColors {
    fun setColor(
            name: String,
            color: Color,
            colorType: AbstractCard.CardColor
    ) {
        val rootImagesPath = "$name/images/"

        BaseMod.addColor(colorType,
                color, color, color, color, color, color, color,
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