package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.{EventHandler, Listener}

class PlayerJoinListener extends Listener {
  @EventHandler
  def onPlayerJoin(event: PlayerJoinEvent): Unit = {
    Seichi915AFK.idleTimer += event.getPlayer -> 0
  }
}
