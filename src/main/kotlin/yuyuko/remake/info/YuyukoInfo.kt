package yuyuko.remake.info

import com.badlogic.gdx.graphics.Color
import com.megacrit.cardcrawl.core.CardCrawlGame
import yuyuko.remake.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardColorEnumPatch
import yuyuko.remake.patches.com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClassEnumPatch

object YuyukoInfo {
    object Customs {
        const val name = "yuyuko"
        val colorType = CardColorEnumPatch.YUYUKO
        val playerType = PlayerClassEnumPatch.YUYUKO
        val color = Color(227f, 48f, 255f, 1f)
    }

    object CharacterInfo {
        const val energy = 3
        const val HP = 40
        const val gold = 99
        const val cardDraw = 5
    }

    object CharacterString {
        private val characterString = CardCrawlGame.languagePack.getCharacterString("yuyuko")
        val name = characterString.NAMES[0]
        val description = characterString.TEXT[0]
    }
}