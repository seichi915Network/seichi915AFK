package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.{EventHandler, Listener}

class InventoryCloseListener extends Listener {
  @EventHandler
  def onInventoryClose(event: InventoryCloseEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getPlayer.asInstanceOf[Player])
}
