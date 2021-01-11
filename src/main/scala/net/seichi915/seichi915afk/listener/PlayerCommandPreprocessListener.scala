package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class PlayerCommandPreprocessListener extends Listener {
  @EventHandler(priority = EventPriority.HIGHEST)
  def onPlayerCommandPreprocess(event: PlayerCommandPreprocessEvent): Unit =
    if (!event.getMessage.equalsIgnoreCase("/afk"))
      Seichi915AFK.resetIdleTimer(event.getPlayer)
}
