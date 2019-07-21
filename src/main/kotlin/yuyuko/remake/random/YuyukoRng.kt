package yuyuko.remake.random

import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.random.Random

object YuyukoRng {
    private val commonRng = Random(Settings.seed)

    fun random(range: Int) = commonRandom(range)

    fun commonRandom(range: Int) = commonRng.random(range)


    fun <T> listRandom(list: List<T>): T? {
        when (list.isEmpty()) {
            true -> return null
            false -> return list[random(list.count())]
        }
    }
}