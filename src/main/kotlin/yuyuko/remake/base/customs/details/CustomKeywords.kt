package yuyuko.remake.base.customs.details

import basemod.BaseMod
import com.megacrit.cardcrawl.core.CardCrawlGame
import yuyuko.remake.base.info.Info

object CustomKeywords {
    fun setKeywords() {
        val keywordList = arrayListOf<String>(
                "Eternal",
                "Fleeting",
                "Hidden",
                "Fading",
                "Rebirth",
                "Sakura",
                "Butterfly",
                "Transparent",
                "Ghost"
        )

        for (keyword in keywordList) {
            val info = getTextOfKeyword(keyword)
            BaseMod.addKeyword(info.nameStrings, info.descriptionStrings)
        }
    }

    private fun getTextOfKeyword(keyword: String) = object {
        val fullName = "${Info.Customs.name}:$keyword"
        val text = CardCrawlGame.languagePack.getKeywordString(fullName).TEXT
        val nameStrings = arrayOf<String>(text[0])
        val descriptionStrings = text[1]
    }
}