package net.seichi915.seichi915afk

import net.seichi915.seichi915afk.command._
import net.seichi915.seichi915afk.listener._
import net.seichi915.seichi915afk.task._
import org.bukkit.command.{CommandExecutor, TabExecutor}
import org.bukkit.{Bukkit, ChatColor}
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

import scala.collection.mutable

object Seichi915AFK {
  var instance: Seichi915AFK = _

  var idleTimer: mutable.HashMap[Player, Int] = mutable.HashMap()
  var originalUsernames: mutable.HashMap[Player, String] = mutable.HashMap()
  var afkPlayers: List[Player] = List()

  def setAFK(player: Player, afk: Boolean): Unit =
    if (afk) {
      if (!afkPlayers.contains(player)) {
        Bukkit.broadcastMessage(
          s"${ChatColor.GRAY}${player.getName} さんが離席しました。")
        originalUsernames += player -> player.getDisplayName
        player.setPlayerListName(s"${ChatColor.GRAY}[離席中] ${player.getName}")
        afkPlayers = afkPlayers.appended(player)
      }
    } else {
      if (afkPlayers.contains(player)) {
        Bukkit.broadcastMessage(
          s"${ChatColor.GRAY}${player.getName} さんが離席解除しました。")
        player.setPlayerListName(originalUsernames(player))
        afkPlayers = afkPlayers.filterNot(
          _.getUniqueId.toString.equalsIgnoreCase(player.getUniqueId.toString))
        originalUsernames.remove(player)
      }
    }

  def resetIdleTimer(player: Player): Unit =
    idleTimer.update(player, 0)
}

class Seichi915AFK extends JavaPlugin {
  Seichi915AFK.instance = this

  override def onEnable(): Unit = {
    Seq(
      new AsyncPlayerChatListener,
      new BlockBreakListener,
      new BlockPlaceListener,
      new EntityCombustByEntityListener,
      new EntityCombustListener,
      new EntityDamageByEntityListener,
      new EntityDamageListener,
      new EntityRegainHealthListener,
      new FoodLevelChangeListener,
      new InventoryClickListener,
      new InventoryCloseListener,
      new InventoryOpenListener,
      new PlayerCommandPreprocessListener,
      new PlayerDropItemListener,
      new PlayerInteractListener,
      new PlayerItemHeldListener,
      new PlayerJoinListener,
      new PlayerMoveListener,
      new PlayerQuitListener,
      new PlayerSwapHandItemsListener,
      new PlayerToggleSneakListener,
      new PotionSplashListener
    ).foreach(Bukkit.getPluginManager.registerEvents(_, this))
    Map(
      "afk" -> new AFKCommand
    ).foreach {
      case (commandName: String, commandExecutor: CommandExecutor) =>
        getServer.getPluginCommand(commandName).setExecutor(commandExecutor)
        getServer
          .getPluginCommand(commandName)
          .setTabCompleter(commandExecutor.asInstanceOf[TabExecutor])
    }
    Map(
      (1, 1) -> new IdleTimerTask
    ).foreach {
      case ((delay: Int, period: Int), bukkitRunnable: BukkitRunnable) =>
        bukkitRunnable.runTaskTimer(this, delay, period)
    }

    getLogger.info("seichi915AFKが有効になりました。")
  }

  override def onDisable(): Unit = {
    getLogger.info("seichi915AFKが無効になりました。")
  }
}
