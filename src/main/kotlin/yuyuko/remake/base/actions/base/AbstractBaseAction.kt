package yuyuko.remake.base.actions.base

import com.megacrit.cardcrawl.actions.AbstractGameAction
import com.megacrit.cardcrawl.core.Settings

abstract class AbstractBaseAction : AbstractGameAction() {
    init {
        this.duration = Settings.ACTION_DUR_MED
    }
}