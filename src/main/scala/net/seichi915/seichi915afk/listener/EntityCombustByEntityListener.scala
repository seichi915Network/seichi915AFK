package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.{Arrow, Player}
import org.bukkit.event.entity.EntityCombustByEntityEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class EntityCombustByEntityListener extends Listener {
  @EventHandler(priority = EventPriority.MONITOR)
  def onEntityCombustByEntity(event: EntityCombustByEntityEvent): Unit = {
    event.getCombuster match {
      case combuster: Arrow
          if event.getEntity
            .isInstanceOf[Player] =>
        combuster.getShooter match {
          case shooter: Player =>
            if (shooter.hasMetadata("NPC")) return
            if (Seichi915AFK.afkPlayers.contains(shooter))
              event.setCancelled(true)
            else Seichi915AFK.resetIdleTimer(shooter)
          case _ =>
        }
      case _ =>
    }
  }
}
