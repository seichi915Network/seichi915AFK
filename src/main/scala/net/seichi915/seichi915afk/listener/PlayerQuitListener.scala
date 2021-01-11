package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerQuitListener extends Listener {
  @EventHandler
  def onPlayerQuit(event: PlayerQuitEvent): Unit = {
    if (Seichi915AFK.idleTimer.contains(event.getPlayer))
      Seichi915AFK.idleTimer.remove(event.getPlayer)
    if (Seichi915AFK.afkPlayers.contains(event.getPlayer))
      Seichi915AFK.afkPlayers = Seichi915AFK.afkPlayers.filterNot(
        _.getUniqueId.toString
          .equalsIgnoreCase(event.getPlayer.getUniqueId.toString))
  }
}
