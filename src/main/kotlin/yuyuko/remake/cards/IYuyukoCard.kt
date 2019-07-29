package yuyuko.remake.cards

interface IYuyukoCard {
    var isHide: Boolean
    var isFading: Boolean
    var isRebirth: Boolean

    fun fading()
}