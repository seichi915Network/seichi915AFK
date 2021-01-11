package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.event.{EventHandler, Listener}

class InventoryOpenListener extends Listener {
  @EventHandler
  def onInventoryOpen(event: InventoryOpenEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer.asInstanceOf[Player])
}
