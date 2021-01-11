package net.seichi915.seichi915afk.command

import net.seichi915.seichi915afk.Seichi915AFK
import net.seichi915.seichi915afk.util.Implicits._
import org.bukkit.command.{Command, CommandExecutor, CommandSender, TabExecutor}
import org.bukkit.entity.Player

import java.util
import java.util.Collections

class AFKCommand extends CommandExecutor with TabExecutor {
  override def onCommand(sender: CommandSender,
                         command: Command,
                         label: String,
                         args: Array[String]): Boolean = {
    if (!sender.isInstanceOf[Player]) {
      sender.sendMessage("このコマンドはプレイヤーのみが実行できます。".toErrorMessage)
      return true
    }
    if (args.length != 0) {
      sender.sendMessage("コマンドの使用法が間違っています。".toErrorMessage)
      return true
    }
    val player = sender.asInstanceOf[Player]
    if (Seichi915AFK.afkPlayers.contains(player)) return true
    if (Seichi915AFK.idleTimer.contains(player))
      Seichi915AFK.idleTimer.remove(player)
    Seichi915AFK.idleTimer += player -> -1
    Seichi915AFK.setAFK(player, afk = true)
    true
  }

  override def onTabComplete(sender: CommandSender,
                             command: Command,
                             alias: String,
                             args: Array[String]): util.List[String] =
    Collections.emptyList()
}
