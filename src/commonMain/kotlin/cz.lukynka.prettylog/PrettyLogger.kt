package cz.lukynka.prettylog

import cz.lukynka.prettylog.style.AnsiColor
import cz.lukynka.prettylog.style.LogPrefix
import cz.lukynka.prettylog.style.StaticLogPrefix
import cz.lukynka.prettylog.style.LogStyle
import kotlin.reflect.KClass

class PrettyLogger(override val prefixes: Collection<LogPrefix>) : Logger() {
    constructor(kclass: KClass<*>) : this(listOf(StaticLogPrefix(" ${kclass.simpleName ?: kclass.toString()} ", LogStyle.FILLED_LIGHT_GRAY)))
    constructor(vararg prefixes: LogPrefix) : this(prefixes.toList())
}

abstract class Logger {
    abstract val prefixes: Collection<LogPrefix>

    fun log(message: String, type: LogType = LogType.RUNTIME) {
        if (PrettyLogSettings.disabledLogTypes.contains(type))
            return

        val resolvedPrefixes = buildString {
            prefixes.forEach { prefix ->
                if (prefix.style.backgroundColor != null) {
                    append(prefix.style.backgroundColor!!.code)
                }
                append(prefix.style.textColor.code)
                append(prefix.getPrefixText())
                append(AnsiColor.RESET.code)
                append(" ")
            }
        }

        val string = "${resolvedPrefixes}${type.resolved}${message}${AnsiColor.RESET}"
        println(string)
        if (PrettyLogSettings.saveToFile) LoggerFileWriter.writeToFile(message, type)
    }

    fun log(throwable: Throwable) {
        val stack = throwable.stackTraceToString().split('\n')
        stack.forEach { this.log(it, LogType.EXCEPTION) }
    }
}