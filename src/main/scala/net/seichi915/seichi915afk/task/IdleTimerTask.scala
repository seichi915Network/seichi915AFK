package net.seichi915.seichi915afk.task

import net.seichi915.seichi915afk.Seichi915AFK
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class IdleTimerTask extends BukkitRunnable {
  override def run(): Unit =
    Seichi915AFK.idleTimer.foreach {
      case (player: Player, time: Int) =>
        if (player.isOnline) {
          if (time != -1) {
            if (time >= 6000) {
              Seichi915AFK.setAFK(player, afk = true)
              Seichi915AFK.idleTimer.update(player, -1)
            } else {
              Seichi915AFK.setAFK(player, afk = false)
              Seichi915AFK.idleTimer.update(player, time + 1)
            }
          }
        } else {
          if (Seichi915AFK.idleTimer.contains(player))
            Seichi915AFK.idleTimer.remove(player)
          if (Seichi915AFK.afkPlayers.contains(player))
            Seichi915AFK.afkPlayers.filterNot(
              _.getUniqueId.toString
                .equalsIgnoreCase(player.getUniqueId.toString))
        }
    }
}
