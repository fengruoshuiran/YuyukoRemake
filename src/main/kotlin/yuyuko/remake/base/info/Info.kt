package yuyuko.remake.base.info

import com.badlogic.gdx.graphics.Color
import com.megacrit.cardcrawl.cards.CardGroup
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.helpers.CardHelper
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardColorEnumPatch
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClassEnumPatch

object Info {
    val faded: CardGroup = CardGroup(CardGroup.CardGroupType.UNSPECIFIED)

    object Customs {
        const val name = "yuyuko"
        val colorType = CardColorEnumPatch.YUYUKO
        val playerType = PlayerClassEnumPatch.YUYUKO
        val color = CardHelper.getColor(227f, 48f, 255f)!!
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

    object Tag {
        val sakura = CardTagsEnumPatch.SAKURA
        val butterfly = CardTagsEnumPatch.BUTTERFLY
    }
}