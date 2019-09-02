package yuyuko.remake.cards

import basemod.abstracts.CustomCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.info.Info
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.cards.AbstractCard.CardTagsEnumPatch

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
        getDescription(id),
        type,
        color,
        rarity,
        target
),
        IYuyukoCard
{
    override val isEternal = false
    override val isFleeting = false

    override var isHidden = false
    override var isFading = false
    override var isRebirth = false

    override fun use(self: AbstractPlayer?, target: AbstractMonster?) {}

    override fun upgrade() {}

    override fun fading() {}

    fun updateDescription() {
        val eternalString = if (isEternal) getKeywordString("Eternal") else ""
        val fleetingString = if (isFleeting) getKeywordString("Fleeting") else ""
        val sakuraString = if (hasTag(Info.Tag.sakura)) getKeywordString("Sakura") else ""
        val butterflyString = if (hasTag(Info.Tag.butterfly)) getKeywordString("Butterfly") else ""
        val hiddenString = if (isHidden) getKeywordString("Hidden") else ""
        val fadingString = if (isHidden) getKeywordString("Fading") else ""
        val rebirthString = if (isHidden) getKeywordString("Rebirth") else ""
        rawDescription = eternalString + fleetingString + sakuraString + butterflyString + rawDescription +
                hiddenString + fadingString + rebirthString
        initializeDescription()
    }

        companion object {
        private const val characterName = Info.Customs.name
        val color = Info.Customs.colorType
        private fun getFullId(id: String) = "$characterName:$id"
        private fun getCardString(id: String) = CardCrawlGame.languagePack.getCardStrings(getFullId(id))
        private fun getName(id: String) = getCardString(id).NAME
        private fun getDescription(id: String) = getCardString(id).DESCRIPTION
        private fun getImgPath(id: String) = "$characterName/images/cards/$id.png"
        private fun getUpdateDescripion(id: String) = getCardString(id).UPGRADE_DESCRIPTION
        private fun getKeywordString(keyword: String) = CardCrawlGame.languagePack
                .getKeywordString("$characterName:$keyword").TEXT[2]
    }
}