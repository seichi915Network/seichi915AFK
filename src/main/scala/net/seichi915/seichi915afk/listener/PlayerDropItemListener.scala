package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerDropItemListener extends Listener {
  @EventHandler
  def onPlayerDropItem(event: PlayerDropItemEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
