package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.{EventHandler, Listener}

class InventoryClickListener extends Listener {
  @EventHandler
  def onInventoryClick(event: InventoryClickEvent): Unit =
    Seichi915AFK.resetIdleTimer(event.getWhoClicked.asInstanceOf[Player])
}
