package cz.lukynka.prettylog.style

interface LogPrefix {
    fun getPrefixText(): String
    val style: LogStyle

    companion object {
        val INFORMATION = StaticLogPrefix("ℹ\uFE0F Information ", LogStyle.FILLED_CYAN)
        val RUNTIME = StaticLogPrefix("✨ Runtime ", LogStyle.FILLED_MAGENTA)
        val DEBUG = StaticLogPrefix("\uD83D\uDD27 Debug ", LogStyle.FILLED_GRAY)
        val NETWORK = StaticLogPrefix("\uD83D\uDD0C Network ", LogStyle.FILLED_BLUE)
        val SUCCESS = StaticLogPrefix("✔\uFE0F Success ", LogStyle.FILLED_BRIGHT_GREEN)
        val WARNING = StaticLogPrefix("⚠\uFE0F Warning ", LogStyle.FILLED_BRIGHT_YELLOW)
        val ERROR = StaticLogPrefix("⛔ Error ", LogStyle.FILLED_RED)
        val EXCEPTION = StaticLogPrefix("\uD83D\uDCA3 Exception ", LogStyle.FILLED_RED)
        val CRITICAL = StaticLogPrefix("🚨 Critical ", LogStyle.FILLED_BRIGHT_RED)
        val AUDIT = StaticLogPrefix("📋 Audit ", LogStyle.FILLED_YELLOW)
        val TRACE = StaticLogPrefix("🔍 Trace ", LogStyle.FILLED_LIGHT_BLUE)
        val SECURITY = StaticLogPrefix("🔒 Security ", LogStyle.FILLED_PURPLE)
        val USER_ACTION = StaticLogPrefix("🧍 User Action ", LogStyle.FILLED_CUTE_PINK)
        val PERFORMANCE = StaticLogPrefix("⏱️ Performance ", LogStyle.FILLED_PINK)
        val CONFIG = StaticLogPrefix("⚙️ Config ", LogStyle.FILLED_LIGHT_GRAY)
        val FATAL = StaticLogPrefix("☠️ Fatal ", LogStyle.FILLED_DARK_RED)
    }
}

data class DynamicLogPrefix(override val style: LogStyle, val textSupplier: () -> String) : LogPrefix {
    override fun getPrefixText(): String {
        return textSupplier.invoke()
    }
}

data class StaticLogPrefix(val text: String, override val style: LogStyle) : LogPrefix {
    override fun getPrefixText(): String {
        return text
    }
}