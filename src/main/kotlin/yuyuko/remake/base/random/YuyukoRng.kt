package yuyuko.remake.base.random

import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.random.Random

object YuyukoRng {
    private val commonRng = Random(Settings.seed)

    fun random(range: Int) = commonRandom(range)

    fun commonRandom(range: Int) = commonRng.random(range)
}