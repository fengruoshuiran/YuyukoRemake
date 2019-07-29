package yuyuko.remake.charcacter

import basemod.abstracts.CustomPlayer
import yuyuko.remake.base.patches.com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClassEnumPatch
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.MathUtils
import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.characters.AbstractPlayer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.core.EnergyManager
import com.megacrit.cardcrawl.helpers.FontHelper
import com.megacrit.cardcrawl.screens.CharSelectInfo
import yuyuko.remake.cards.yuyuko.Sakura
import yuyuko.remake.base.info.Info

class CustomYuyuko() : CustomPlayer(
        CardCrawlGame.playerName,
        PlayerClassEnumPatch.YUYUKO,
        arrayOf(
                "yuyuko/images/orbs/orb/layer1.png",
                "yuyuko/images/orbs/orb/layer2.png",
                "yuyuko/images/orbs/orb/layer3.png",
                "yuyuko/images/orbs/orb/layer4.png",
                "yuyuko/images/orbs/orb/layer5.png",
                "yuyuko/images/orbs/orb/layer6.png",
                "yuyuko/images/orbs/orb/layer1d.png",
                "yuyuko/images/orbs/orb/layer2d.png",
                "yuyuko/images/orbs/orb/layer3d.png",
                "yuyuko/images/orbs/orb/layer4d.png",
                "yuyuko/images/orbs/orb/layer5d.png"
        ),
        "yuyuko/images/orbs/orb/vfx.png",
        null as String?,
        null as String?
) {
    init {
        this.initializeClass(
                null,
                "yuyuko/images/character/shoulder2.png",
                "yuyuko/images/character/shoulder.png",
                "yuyuko/images/character/corpse.png",
                getLoadout(),
                20.0f, -10.0f, 220.0f, 290.0f,
                EnergyManager(Info.CharacterInfo.energy)
        )

        this.loadAnimation(
                "yuyuko/images/animate/animate.atlas",
                "yuyuko/images/animate/animate.json",
                0.9f
        )

        val e = this.state.setAnimation(0, "Sprite", true)
        e.time = e.endTime * MathUtils.random()
        e.timeScale = .25f
    }

    override fun getStartingDeck(): ArrayList<String> {
        val list = arrayListOf<String>(
                "yuyuko:Sakura",
                "yuyuko:Sakura",
                "yuyuko:Sakura",
                "yuyuko:Sakura",
                "yuyuko:Sakura",
                "yuyuko:Sakura",
                "yuyuko:Butterfly",
                "yuyuko:Butterfly",
                "yuyuko:Butterfly",
                "yuyuko:Butterfly",
                "yuyuko:Butterfly",
                "yuyuko:Butterfly"
        )
        //TODO: Add start list
        return list
    }

    override fun getStartingRelics(): ArrayList<String> {
        return arrayListOf("yuyuko:Yuyuko's Fan")
    }

    override fun getLoadout(): CharSelectInfo {
        return CharSelectInfo(
                Info.CharacterString.name,
                Info.CharacterString.description,
                Info.CharacterInfo.HP,
                Info.CharacterInfo.HP,
                0,
                Info.CharacterInfo.gold,
                Info.CharacterInfo.cardDraw,
                this,
                startingRelics,
                startingDeck,
                false)
    }

    override fun getTitle(p0: PlayerClass?): String = Info.CharacterString.name

    override fun getCardColor(): AbstractCard.CardColor = Info.Customs.colorType

    override fun getStartCardForEvent(): AbstractCard = Sakura()

    override fun getCardTrailColor(): Color = Info.Customs.color

    override fun getAscensionMaxHPLoss(): Int = 0

    override fun getEnergyNumFont(): BitmapFont = FontHelper.energyNumFontGreen

    override fun doCharSelectScreenSelectEffect() {}

    override fun getCustomModeCharacterButtonSoundKey(): String = "ATTACK_MAGIC_BEAM_SHORT"

    override fun getLocalizedCharacterName(): String = Info.CharacterString.name

    override fun newInstance(): AbstractPlayer = CustomYuyuko()

    override fun getCardRenderColor(): Color = Info.Customs.color

    override fun getSlashAttackColor(): Color = Info.Customs.color

    override fun getSpireHeartText(): String = CardCrawlGame.languagePack
            .getEventString("spireHeart").DESCRIPTIONS[0]

    override fun getVampireText(): String = CardCrawlGame.languagePack
            .getEventString("vampire").DESCRIPTIONS[0]

    override fun getSpireHeartSlashEffect(): Array<AbstractGameAction.AttackEffect> =
            arrayOf(
                    AbstractGameAction.AttackEffect.SLASH_HEAVY,
                    AbstractGameAction.AttackEffect.FIRE,
                    AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                    AbstractGameAction.AttackEffect.SLASH_HEAVY,
                    AbstractGameAction.AttackEffect.FIRE,
                    AbstractGameAction.AttackEffect.BLUNT_HEAVY
            )

}