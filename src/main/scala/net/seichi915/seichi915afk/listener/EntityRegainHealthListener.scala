package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.{EventHandler, Listener}

class EntityRegainHealthListener extends Listener {
  @EventHandler
  def onEntityRegainHealth(event: EntityRegainHealthEvent): Unit = {
    event.getEntity match {
      case player: Player if Seichi915AFK.afkPlayers.contains(player) =>
        event.setCancelled(true)
      case _ =>
    }
  }
}
