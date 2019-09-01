package yuyuko.remake.base.actions.base

import com.badlogic.gdx.Gdx
import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.unlock.UnlockTracker
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect

class AddCardToDrawPileBaseAction (private val card: AbstractCard) : AbstractGameAction() {
    init {
        UnlockTracker.markCardAsSeen(card.cardID)
        setValues(this.target, this.source, amount)
        duration = DURATION
    }

    private val randomSpot = true
    private val autoPosition = true
    private val toBottom = false
    private val x = Settings.WIDTH.toFloat() / 2.0f
    private val y = Settings.HEIGHT.toFloat() / 2.0f

    override fun update() {
        if (duration == DURATION) {
            AbstractDungeon.effectList.add(ShowCardAndAddToDrawPileEffect(
                    card.makeStatEquivalentCopy(), x, y, randomSpot, autoPosition, toBottom)
            )
            duration -= Gdx.graphics.deltaTime
        }

        tickDuration()
    }

    companion object {
        const val DURATION = 0.1F
    }
}