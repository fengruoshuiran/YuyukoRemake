package yuyuko.remake.cards

interface IYuyukoCard {
    var isHide: Boolean
    var isDying: Boolean
    var isRebirth: Boolean

    fun dying()
}