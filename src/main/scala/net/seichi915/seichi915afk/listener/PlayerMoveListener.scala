package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerMoveListener extends Listener {
  @EventHandler
  def onPlayerMove(event: PlayerMoveEvent): Unit = {
    if (Seichi915AFK.afkPlayers.contains(event.getPlayer))
      event.setCancelled(true)
    else Seichi915AFK.resetIdleTimer(event.getPlayer)
  }
}
