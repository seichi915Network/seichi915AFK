package net.seichi915.seichi915afk.listener

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.event.entity.PotionSplashEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}

class PotionSplashListener extends Listener {
  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
  def onPotionSplash(event: PotionSplashEvent): Unit = {
    import scala.jdk.CollectionConverters._
    event.getAffectedEntities.asScala.foreach {
      case livingEntity @ (player: Player) =>
        if (Seichi915AFK.afkPlayers.contains(player))
          event.setIntensity(livingEntity, 0d)
        else Seichi915AFK.resetIdleTimer(player)
      case _ =>
    }
  }
}
