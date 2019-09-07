package yuyuko.remake.base.actions.utils

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.monsters.AbstractMonster
import yuyuko.remake.base.random.YuyukoRng

object Utils {
    fun getRandomEnemy(): AbstractMonster? = AbstractDungeon.getCurrRoom().monsters.monsters
                .filter { !it.isDeadOrEscaped }.let {
                    it.elementAtOrNull(YuyukoRng.random(it.count() - 1))
    }
}