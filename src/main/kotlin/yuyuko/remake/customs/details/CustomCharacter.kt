package yuyuko.remake.customs.details

import basemod.BaseMod
import com.megacrit.cardcrawl.characters.AbstractPlayer
import yuyuko.remake.charcacter.CustomYuyuko

object CustomCharacter {
    fun setCharacter(
            name: String,
            playerType: AbstractPlayer.PlayerClass
    ) {
        val selectButtonPath = "$name/images/character/button.png"
        val portraitPath = "$name/images/character/portrait.png"
        BaseMod.addCharacter(CustomYuyuko(), selectButtonPath, portraitPath, playerType)
    }
}