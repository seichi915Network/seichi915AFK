package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.{EventHandler, Listener}

class AsyncPlayerChatListener extends Listener {
  @EventHandler
  def onAsyncPlayerChat(event: AsyncPlayerChatEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
