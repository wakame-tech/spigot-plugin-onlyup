package tech.wakame.onlyup

import org.bukkit.plugin.java.JavaPlugin
import tech.wakame.onlyup.handlers.PlayerBoundOnBedHandler

class Onlyup : JavaPlugin() {
    private val handlers = arrayOf(PlayerBoundOnBedHandler(this))

    override fun onEnable() {
        saveDefaultConfig()

        handlers.forEach {
            server.pluginManager.registerEvents(it, this)
        }
    }

    override fun onDisable() {}
}