package yuyuko.remake.customs

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
                "scorebonus" -> ScoreBonusStrings::class.java
                "character" -> CharacterStrings::class.java
                "ui" -> UIStrings::class.java
                "orb" -> OrbStrings::class.java
                "RunMod" -> RunModStrings::class.java
                "blight" -> BlightStrings::class.java
                "achievement" -> AchievementStrings::class.java
                else -> AchievementStrings::class.java
            }

            setString(name, stringType, stringTypeClass)
        }
    }
}