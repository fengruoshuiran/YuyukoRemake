package yuyuko.remake.base.events

import org.apache.logging.log4j.LogManager
import yuyuko.remake.cards.yuyuko.Sakura
import yuyuko.remake.base.events.info.AbstractHookInfo
import yuyuko.remake.base.events.yuyuko.AbstractYuyukoEvent
import yuyuko.remake.base.events.yuyuko.FadingYuyukoEvent
import yuyuko.remake.base.events.yuyuko.HideYuyukoEvent
import yuyuko.remake.base.events.info.OnDrawHookInfo

object EventManager {
    private val relationship: MutableMap<String, MutableSet<AbstractYuyukoEvent>> = mutableMapOf()
    private val logger = LogManager.getLogger(this.javaClass.name)

    fun initSubscribe() {
        subscribe(OnDrawHookInfo(Sakura()).hookName, HideYuyukoEvent())
        subscribe(OnDrawHookInfo(Sakura()).hookName, FadingYuyukoEvent())
    }

    fun subscribe(publisher: String, subscriber: AbstractYuyukoEvent) {
        if(relationship[publisher] == null) relationship[publisher] = mutableSetOf()
        relationship[publisher]?.add(subscriber)
    }

    fun unsubscribe(publisher: String, subscriber: AbstractYuyukoEvent) { relationship[publisher]?.remove(subscriber) }

    fun call(hookInfo: AbstractHookInfo) {
        for (subscriber in relationship[hookInfo.hookName]!!) {
            val isDone = subscriber.call(hookInfo)
            logger.info("${hookInfo.hookName} called ${subscriber.javaClass.name}.IsDone: $isDone")
            if(isDone) break
        }
    }
}