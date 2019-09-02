package yuyuko.remake.cards

interface IYuyukoCard {
    val isEternal: Boolean
    val isFleeting: Boolean

    var isHidden: Boolean
    var isFading: Boolean
    var isRebirth: Boolean

    fun fading()
}