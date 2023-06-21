package tech.wakame.onlyup.handlers

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.util.Vector
import tech.wakame.onlyup.Onlyup

class PlayerBoundOnBedHandler(private val plugin: Onlyup) : Listener {
    private val jumpVelocityCoefficient = plugin.config.getDouble("jump_velocity_coefficient", -5.0)

    @EventHandler
    fun onPlayerMove(e: PlayerMoveEvent) {
        if (e.player.location.block.getRelative(BlockFace.DOWN).type == Material.RED_BED) {
            val v = e.player.velocity.multiply(Vector(1.0, jumpVelocityCoefficient, 1.0))
            e.player.velocity = v
        }
    }
}