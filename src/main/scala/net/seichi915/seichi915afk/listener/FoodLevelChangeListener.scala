package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class FoodLevelChangeListener extends Listener {
  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
  def onFoodLevelChange(event: FoodLevelChangeEvent): Unit = {
    event.getEntity match {
      case player: Player if Seichi915AFK.afkPlayers.contains(player) =>
        event.setCancelled(true)
      case _ =>
    }
  }
}
