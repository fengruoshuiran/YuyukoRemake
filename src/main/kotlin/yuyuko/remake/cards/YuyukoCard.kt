package yuyuko.remake.cards

import basemod.abstracts.CustomCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardColorEnumPatch

abstract class YuyukoCard(
        id: String,
        cost: Int,
        type: CardType,
        rarity: CardRarity,
        target: CardTarget
) : CustomCard(
        getFullId(id),
        getName(id),
        getImgPath(id),
        cost,
        getDescripion(id),
        type,
        color,
        rarity,
        target
),
        IYuyukoCard
{

    override var isHide = false
    override var isBloom = false
    override var isWither = false
    override var isRevive = false

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {}

    override fun upgrade() {}

    override fun bloom() {}

    companion object {
        private val characterName = "yuyuko"
        val color = CardColorEnumPatch.YUYUKO
        private fun getFullId(id: String) = "$characterName:$id"
        private fun getName(id: String) = CardCrawlGame.languagePack.getCardStrings(getFullId(id)).NAME
        private fun getDescripion(id: String) = CardCrawlGame.languagePack.getCardStrings(getFullId(id)).DESCRIPTION
        private fun getImgPath(id: String) = "$characterName/images/cards/$id.png"
        private fun getUpdateDescripion(id: String) = CardCrawlGame.languagePack.getCardStrings(getFullId(id)).UPGRADE_DESCRIPTION
    }
}