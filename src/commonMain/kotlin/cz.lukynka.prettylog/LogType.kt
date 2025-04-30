package cz.lukynka.prettylog

/**
 * Enum representing log severity levels from least severe to most severe
 */
enum class LogSeverity {
    TRACE,
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL
}

object LogType {
    val INFORMATION = CustomLogType("ℹ\uFE0F Information", AnsiPair.CYAN, LogSeverity.INFO)
    val RUNTIME = CustomLogType("✨ Runtime", AnsiPair.MAGENTA, LogSeverity.INFO)
    val DEBUG = CustomLogType("\uD83D\uDD27 Debug", AnsiPair.GRAY, LogSeverity.DEBUG)
    val NETWORK = CustomLogType("\uD83D\uDD0C Network", AnsiPair.BLUE, LogSeverity.INFO)
    val SUCCESS = CustomLogType("✔\uFE0F Success", AnsiPair.BRIGHT_GREEN, LogSeverity.INFO)
    val WARNING = CustomLogType("⚠\uFE0F Warning", AnsiPair.BRIGHT_YELLOW, LogSeverity.WARNING)
    val ERROR = CustomLogType("⛔ Error", AnsiPair.RED, LogSeverity.ERROR)
    val EXCEPTION = CustomLogType("\uD83D\uDCA3 Exception", AnsiPair.RED, LogSeverity.ERROR)
    val CRITICAL = CustomLogType("🚨 Critical", AnsiPair.BRIGHT_RED, LogSeverity.ERROR)
    val AUDIT = CustomLogType("📋 Audit", AnsiPair.YELLOW, LogSeverity.INFO)
    val TRACE = CustomLogType("🔍 Trace", AnsiPair.LIGHT_BLUE, LogSeverity.TRACE)
    val SECURITY = CustomLogType("🔒 Security", AnsiPair.PURPLE, LogSeverity.WARNING)
    val USER_ACTION = CustomLogType("🧍 User Action", AnsiPair.CUTE_PINK, LogSeverity.INFO)
    val PERFORMANCE = CustomLogType("⏱️ Performance", AnsiPair.PINK, LogSeverity.INFO)
    val CONFIG = CustomLogType("⚙️ Config", AnsiPair.LIGHT_GRAY, LogSeverity.INFO)
    val FATAL = CustomLogType("☠️ Fatal", AnsiPair.DARK_RED, LogSeverity.FATAL)
}

data class CustomLogType(
    val name: String,
    val colorPair: AnsiPair,
    val severity: LogSeverity = LogSeverity.INFO
)
