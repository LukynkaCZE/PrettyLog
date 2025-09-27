package cz.lukynka.prettylog.style

data class LogPrefix(val text: String, val style: LogStyle) {
    companion object {
        val INFORMATION = LogPrefix("ℹ\uFE0F Information ", LogStyle.FILLED_CYAN)
        val RUNTIME = LogPrefix("✨ Runtime ", LogStyle.FILLED_MAGENTA)
        val DEBUG = LogPrefix("\uD83D\uDD27 Debug ", LogStyle.FILLED_GRAY)
        val NETWORK = LogPrefix("\uD83D\uDD0C Network ", LogStyle.FILLED_BLUE)
        val SUCCESS = LogPrefix("✔\uFE0F Success ", LogStyle.FILLED_BRIGHT_GREEN)
        val WARNING = LogPrefix("⚠\uFE0F Warning ", LogStyle.FILLED_BRIGHT_YELLOW)
        val ERROR = LogPrefix("⛔ Error ", LogStyle.FILLED_RED)
        val EXCEPTION = LogPrefix("\uD83D\uDCA3 Exception ", LogStyle.FILLED_RED)
        val CRITICAL = LogPrefix("🚨 Critical ", LogStyle.FILLED_BRIGHT_RED)
        val AUDIT = LogPrefix("📋 Audit ", LogStyle.FILLED_YELLOW)
        val TRACE = LogPrefix("🔍 Trace ", LogStyle.FILLED_LIGHT_BLUE)
        val SECURITY = LogPrefix("🔒 Security ", LogStyle.FILLED_PURPLE)
        val USER_ACTION = LogPrefix("🧍 User Action ", LogStyle.FILLED_CUTE_PINK)
        val PERFORMANCE = LogPrefix("⏱️ Performance ", LogStyle.FILLED_PINK)
        val CONFIG = LogPrefix("⚙️ Config ", LogStyle.FILLED_LIGHT_GRAY)
        val FATAL = LogPrefix("☠️ Fatal ", LogStyle.FILLED_DARK_RED)
    }
}