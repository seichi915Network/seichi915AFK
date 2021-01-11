package net.seichi915.seichi915afk.util

import org.bukkit.ChatColor

object Implicits {
  implicit class StringOps(string: String) {
    def toNormalMessage: String =
      s"${ChatColor.AQUA}[${ChatColor.WHITE}seichi915AFK${ChatColor.AQUA}]${ChatColor.RESET} $string"

    def toSuccessMessage: String =
      s"${ChatColor.AQUA}[${ChatColor.GREEN}seichi915AFK${ChatColor.AQUA}]${ChatColor.RESET} $string"

    def toWarningMessage: String =
      s"${ChatColor.AQUA}[${ChatColor.GOLD}seichi915AFK${ChatColor.AQUA}]${ChatColor.RESET} $string"

    def toErrorMessage: String =
      s"${ChatColor.AQUA}[${ChatColor.RED}seichi915AFK${ChatColor.AQUA}]${ChatColor.RESET} $string"
  }
}
