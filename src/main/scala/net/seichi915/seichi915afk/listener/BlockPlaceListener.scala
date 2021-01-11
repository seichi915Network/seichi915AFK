package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.{EventHandler, Listener}

class BlockPlaceListener extends Listener {
  @EventHandler
  def onBlockPlace(event: BlockPlaceEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
