package cz.lukynka.prettylog

import cz.lukynka.prettylog.style.AnsiColor
import cz.lukynka.prettylog.style.LogPrefix
import cz.lukynka.prettylog.style.StaticLogPrefix
import cz.lukynka.prettylog.style.LogStyle

data class LogType(val textStyle: LogStyle, val prefixes: Collection<StaticLogPrefix> = listOf()) {

    constructor(textStyle: LogStyle, vararg prefixes: StaticLogPrefix) : this(textStyle, prefixes.toList())

    val resolved: String = buildString {
        prefixes.forEach { prefix ->
            if (prefix.style.backgroundColor != null) {
                append(prefix.style.backgroundColor.code)
            }
            append(prefix.style.textColor.code)
            append(prefix.getPrefixText())
            append(AnsiColor.RESET.code)
            append(" ")
        }

        if (textStyle.backgroundColor != null) {
            append(textStyle.backgroundColor.code)
        }
        append(textStyle.textColor.code)
    }

    companion object {
        val INFORMATION = LogType(LogStyle.CYAN, LogPrefix.INFORMATION)
        val RUNTIME = LogType(LogStyle.MAGENTA, LogPrefix.RUNTIME)
        val DEBUG = LogType(LogStyle.GRAY, LogPrefix.DEBUG)
        val NETWORK = LogType(LogStyle.BLUE, LogPrefix.NETWORK)
        val SUCCESS = LogType(LogStyle.BRIGHT_GREEN, LogPrefix.SUCCESS)
        val WARNING = LogType(LogStyle.BRIGHT_YELLOW, LogPrefix.WARNING)
        val ERROR = LogType(LogStyle.RED, LogPrefix.ERROR)
        val EXCEPTION = LogType(LogStyle.RED, LogPrefix.EXCEPTION)
        val CRITICAL = LogType(LogStyle.BRIGHT_RED, LogPrefix.CRITICAL)
        val AUDIT = LogType(LogStyle.YELLOW, LogPrefix.AUDIT)
        val TRACE = LogType(LogStyle.LIGHT_BLUE, LogPrefix.TRACE)
        val SECURITY = LogType(LogStyle.PURPLE, LogPrefix.SECURITY)
        val USER_ACTION = LogType(LogStyle.CUTE_PINK, LogPrefix.USER_ACTION)
        val PERFORMANCE = LogType(LogStyle.PINK, LogPrefix.PERFORMANCE)
        val CONFIG = LogType(LogStyle.LIGHT_GRAY, LogPrefix.CONFIG)
        val FATAL = LogType(LogStyle.FILLED_DARK_RED, LogPrefix.FATAL)
    }
}