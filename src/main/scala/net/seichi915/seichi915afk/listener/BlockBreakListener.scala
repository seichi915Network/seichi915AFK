package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.{EventHandler, Listener}

class BlockBreakListener extends Listener {
  @EventHandler
  def onBlockBreak(event: BlockBreakEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer)
}
