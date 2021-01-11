package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerItemHeldEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerItemHeldListener extends Listener {
  @EventHandler
  def onPlayerItemHeld(event: PlayerItemHeldEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
