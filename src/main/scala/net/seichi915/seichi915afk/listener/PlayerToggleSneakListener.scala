package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerToggleSneakListener extends Listener {
  @EventHandler
  def onPlayerToggleSneak(event: PlayerToggleSneakEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
