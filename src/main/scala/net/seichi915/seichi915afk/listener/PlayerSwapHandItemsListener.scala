package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerSwapHandItemsListener extends Listener {
  @EventHandler
  def onPlayerSwapHandItems(event: PlayerSwapHandItemsEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
