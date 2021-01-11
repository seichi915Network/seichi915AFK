package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityCombustEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class EntityCombustListener extends Listener {
  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
  def onEntityCombust(event: EntityCombustEvent): Unit = {
    event.getEntity match {
      case player: Player =>
        if (Seichi915AFK.afkPlayers.contains(player)) event.setCancelled(true)
        else Seichi915AFK.resetIdleTimer(player)
      case _ =>
    }
  }
}
