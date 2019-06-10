package yuyuko.remake.customs

import com.badlogic.gdx.graphics.Color
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.localization.CharacterStrings
import yuyuko.remake.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardColorEnumPatch
import yuyuko.remake.patches.com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClassEnumPatch

object Customs{
    val name = "yuyuko"
    val colorType = CardColorEnumPatch.YUYUKO
    val playerType = PlayerClassEnumPatch.YUYUKO
    val color = Color(227f, 48f, 255f, 1f)

    object BaseInfo{
        val energy = 3
        val HP = 40
        val gold = 99
        val cardDraw = 5
    }

    object CharacterString{
        val characterString = CardCrawlGame.languagePack.getCharacterString("yuyuko")
        val name = characterString.NAMES[0]
        val description = characterString.TEXT[0]
    }

    fun setColor() = CustomColors.setColor(name, color, colorType)

    fun setCharacter() = CustomCharacter.setCharacter(name, playerType)

    fun setStrings() = CustomStrings.setStrings(name, arrayOf(
            "card",
            "event",
            "character",
            "relic"
    ))

    fun setCards() = CustomCards.setCards()

    fun setRelics() = CustomRelics.setRelics()
}