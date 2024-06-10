package cz.lukynka.prettylog

object LogType {
    val INFORMATION = CustomLogType("ℹ\uFE0F Information", AnsiPair.CYAN)
    val RUNTIME = CustomLogType("✨ Runtime", AnsiPair.MAGENTA)
    val DEBUG = CustomLogType("\uD83D\uDD27 Debug", AnsiPair.GRAY)
    val NETWORK = CustomLogType("\uD83D\uDD0C Network", AnsiPair.BLUE)
    val SUCCESS = CustomLogType("✔\uFE0F Success", AnsiPair.BRIGHT_GREEN)
    val WARNING = CustomLogType("⚠\uFE0F Warning", AnsiPair.BRIGHT_YELLOW)
    val ERROR = CustomLogType("⛔ Error", AnsiPair.RED)
    val EXCEPTION = CustomLogType("\uD83D\uDCA3 Exception", AnsiPair.RED)
    val CRITICAL = CustomLogType("🚨 Critical", AnsiPair.BRIGHT_RED)
    val AUDIT = CustomLogType("📋 Audit", AnsiPair.YELLOW)
    val TRACE = CustomLogType("🔍 Trace", AnsiPair.LIGHT_BLUE)
    val SECURITY = CustomLogType("🔒 Security", AnsiPair.PURPLE)
    val USER_ACTION = CustomLogType("🧍 User Action", AnsiPair.CUTE_PINK)
    val PERFORMANCE = CustomLogType("⏱️ Performance", AnsiPair.PINK)
    val CONFIG = CustomLogType("⚙️ Config", AnsiPair.LIGHT_GRAY)
    val FATAL = CustomLogType("☠️ Fatal", AnsiPair.DARK_RED)
}

data class CustomLogType(
    val name: String,
    val colorPair: AnsiPair
)
