package yuyuko.remake.base.customs.details

import basemod.BaseMod
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.core.Settings.GameLanguage.*
import com.megacrit.cardcrawl.localization.*

object CustomStrings {
    fun setString(name: String, stringType: String, stringTypeClass: Class<*>) {
        val language = when(Settings.language) {
                ZHS -> "zhs"
                ZHT -> "zhs"
                else -> "eng"
        }
        val stringPath = "$name/localization/$language/$stringType.json"

        BaseMod.loadCustomStringsFile(stringTypeClass, stringPath)
    }

    fun setStrings(name: String, stringTypes: Array<String>) {
        for (stringType in stringTypes) {
            val stringTypeClass = when(stringType) {
                "monster" -> MonsterStrings::class.java
                "power" -> PowerStrings::class.java
                "card" -> CardStrings::class.java
                "relic" -> RelicStrings::class.java
                "event" -> EventStrings::class.java
                "potion" -> PotionStrings::class.java
                "credit" -> CreditStrings::class.java
                "tutorial" -> TutorialStrings::class.java
                "keyword" -> KeywordStrings::class.java
                "scoreBonus" -> ScoreBonusStrings::class.java
                "character" -> CharacterStrings::class.java
                "ui" -> UIStrings::class.java
                "orb" -> OrbStrings::class.java
                "runMod" -> RunModStrings::class.java
                "blight" -> BlightStrings::class.java
                "achievement" -> AchievementStrings::class.java
                else -> AchievementStrings::class.java
            }

            setString(name, stringType, stringTypeClass)
        }
    }
}