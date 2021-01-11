package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class EntityDamageByEntityListener extends Listener {
  @EventHandler(priority = EventPriority.LOW)
  def onEntityDamageByEntity(event: EntityDamageByEntityEvent): Unit = {
    val eAttack = event.getDamager
    val eDefend = event.getEntity
    eAttack match {
      case player: Player if eDefend.isInstanceOf[Player] =>
        if (Seichi915AFK.afkPlayers.contains(player)) event.setCancelled(true)
        else Seichi915AFK.resetIdleTimer(player)
      case _ =>
    }
  }
}
