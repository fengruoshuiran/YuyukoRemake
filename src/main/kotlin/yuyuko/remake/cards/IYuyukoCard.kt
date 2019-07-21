package yuyuko.remake.cards

interface IYuyukoCard {
    var isHide: Boolean
    var isBloom: Boolean
    var isWither: Boolean
    var isRevive: Boolean

    fun bloom()
}