package yuyuko.remake.base.actions

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import yuyuko.remake.base.actions.yuyuko.AbstractYuyukoAction

object YuyukoActionManager {
    val logger: Logger = LogManager.getLogger(this.javaClass.name)

    fun add(action: AbstractYuyukoAction) = action.action()
}