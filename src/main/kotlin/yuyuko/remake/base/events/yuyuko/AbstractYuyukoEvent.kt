package yuyuko.remake.base.events.yuyuko

import yuyuko.remake.base.events.info.AbstractHookInfo

abstract class AbstractYuyukoEvent {
    abstract fun call(info: AbstractHookInfo): Boolean
}