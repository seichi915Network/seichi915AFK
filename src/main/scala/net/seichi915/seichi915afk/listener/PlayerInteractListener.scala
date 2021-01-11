package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerInteractListener extends Listener {
  @EventHandler
  def onInteract(event: PlayerInteractEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
