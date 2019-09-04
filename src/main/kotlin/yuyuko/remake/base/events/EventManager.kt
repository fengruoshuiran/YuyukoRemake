package yuyuko.remake.base.events

import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.yuyuko.AbstractYuyukoEvent
import yuyuko.remake.base.events.yuyuko.FadingYuyukoEvent
import yuyuko.remake.base.events.yuyuko.HiddenYuyukoEvent
import yuyuko.remake.base.events.info.OnDrawHookInfo
import yuyuko.remake.base.events.info.OnShuffleHookInfo
import yuyuko.remake.base.events.yuyuko.RebirthYuyukoEvent
import yuyuko.remake.cards.yuyuko.token.Sakura

object EventManager {
    private val relationship: MutableMap<String, MutableSet<AbstractYuyukoEvent>> = mutableMapOf()

    fun initSubscribe() {
        subscribe(OnDrawHookInfo(Sakura()).hookName, HiddenYuyukoEvent())
        subscribe(OnDrawHookInfo(Sakura()).hookName, FadingYuyukoEvent())
        subscribe(OnShuffleHookInfo().hookName, RebirthYuyukoEvent())
    }

    fun subscribe(publisher: String, subscriber: AbstractYuyukoEvent) {
        if(relationship[publisher] == null) relationship[publisher] = mutableSetOf()
        relationship[publisher]?.add(subscriber)
    }

    fun unsubscribe(publisher: String, subscriber: AbstractYuyukoEvent) { relationship[publisher]?.remove(subscriber) }

    fun call(hookInfo: AbstractHookInfo) {
        for (subscriber in relationship[hookInfo.hookName]!!) {
            val isDone = subscriber.call(hookInfo)
            if(isDone) break
        }
    }
}