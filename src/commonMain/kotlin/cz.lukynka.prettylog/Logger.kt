package cz.lukynka.prettylog

object LoggerSettings {
    var saveToFile = true
    var saveDirectoryPath = "./logs/"
    var loggerStyle = LoggerStyle.PREFIX
    var logFileNameFormat = "yyyy-MM-dd-HHmmss"
}

enum class LoggerStyle(val pattern: String) {
    FULL("<background><black><prefix>: <message>"),
    PREFIX("<background><black><prefix>:<reset> <foreground><message>"),
    SUFFIX("<foreground><prefix>: <background><black><message>"),
    TEXT_ONLY("<foreground><prefix>: <message>"),
    PREFIX_WHITE_TEXT("<background><black><prefix>:<reset> <message>"),
    BRACKET_PREFIX("<foreground><bold>[<prefix>]<reset><foreground> <message>"),
    BRACKET_PREFIX_WHITE_TEXT("<foreground><bold>[<prefix>] <reset><message>")
}

fun log(message: String, type: CustomLogType = LogType.RUNTIME) {
    var pattern = LoggerSettings.loggerStyle.pattern
    if(type == LogType.FATAL) pattern = LoggerStyle.FULL.pattern
    pattern = pattern.replace("<background>", type.colorPair.background.code)
    pattern = pattern.replace("<foreground>", type.colorPair.foreground.code)
    pattern = pattern.replace("<black>", AnsiColor.BLACK.code)
    pattern = pattern.replace("<prefix>", type.name)
    pattern = pattern.replace("<message>", message)
    pattern = pattern.replace("<reset>", AnsiColor.RESET.code)
    pattern = pattern.replace("<bold>", AnsiColor.BOLD.code)

    println("$pattern${AnsiColor.RESET}")
    if(LoggerSettings.saveToFile) LoggerFileWriter.writeToFile(message, type)
}

fun log(exception: Exception) {
    val exceptionResult = runCatching {
        throw Exception("${exception.message}")
    }

    val exception = exceptionResult.exceptionOrNull()!!
    val stack = exception.stackTraceToString().split('\n')
    stack.forEach {
        log(it, LogType.EXCEPTION)
    }
}