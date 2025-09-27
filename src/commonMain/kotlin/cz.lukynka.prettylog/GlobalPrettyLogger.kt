package cz.lukynka.prettylog

import cz.lukynka.prettylog.style.LogPrefix

object GlobalPrettyLogger : Logger() {
    override val prefixes: Collection<LogPrefix> = listOf()
}

fun log(message: String, type: LogType = LogType.RUNTIME) {
    GlobalPrettyLogger.log(message, type)
}

fun log(throwable: Throwable) {
    GlobalPrettyLogger.log(throwable)
}