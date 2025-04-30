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

/**
 * Logger object that provides methods for logging with different log types.
 * Each method accepts a lambda that is only evaluated if the log will be processed.
 */
object Log {
    fun d(messageProvider: () -> String) = logInternal(messageProvider(), LogType.DEBUG)
    fun i(messageProvider: () -> String) = logInternal(messageProvider(), LogType.INFORMATION)
    fun r(messageProvider: () -> String) = logInternal(messageProvider(), LogType.RUNTIME)
    fun n(messageProvider: () -> String) = logInternal(messageProvider(), LogType.NETWORK)
    fun s(messageProvider: () -> String) = logInternal(messageProvider(), LogType.SUCCESS)
    fun w(messageProvider: () -> String) = logInternal(messageProvider(), LogType.WARNING)
    fun e(messageProvider: () -> String) = logInternal(messageProvider(), LogType.ERROR)
    fun c(messageProvider: () -> String) = logInternal(messageProvider(), LogType.CRITICAL)
    fun a(messageProvider: () -> String) = logInternal(messageProvider(), LogType.AUDIT)
    fun t(messageProvider: () -> String) = logInternal(messageProvider(), LogType.TRACE)
    fun sec(messageProvider: () -> String) = logInternal(messageProvider(), LogType.SECURITY)
    fun u(messageProvider: () -> String) = logInternal(messageProvider(), LogType.USER_ACTION)
    fun p(messageProvider: () -> String) = logInternal(messageProvider(), LogType.PERFORMANCE)
    fun conf(messageProvider: () -> String) = logInternal(messageProvider(), LogType.CONFIG)
    fun f(messageProvider: () -> String) = logInternal(messageProvider(), LogType.FATAL)

    fun custom(type: CustomLogType, messageProvider: () -> String) = logInternal(messageProvider(), type)

    /**
     * @deprecated Use Log.exception { exception } instead for better performance
     */
    @Deprecated("Use Log.exception { exception } instead for better performance", ReplaceWith("Log.exception { exception }"))
    fun exception(exception: Exception) {
        exceptionInternal(exception)
    }

    fun exception(exceptionProvider: () -> Exception) {
        exceptionInternal(exceptionProvider())
    }

    private fun exceptionInternal(exception: Exception) {
        val stack = exception.stackTraceToString().split('\n')
        stack.forEach {
            logInternal(it, LogType.EXCEPTION)
        }
    }

    /**
     * Internal logging function that doesn't use deprecated APIs
     */
    private fun logInternal(message: String, type: CustomLogType) {
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
}

/**
 * @deprecated Use Logger.custom(type) { "message" } instead for better performance
 */
@Deprecated("Use Logger.custom(type) { \"message\" } instead for better performance", ReplaceWith("Logger.custom(type) { message }"))
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

/**
 * @deprecated Use Logger.exception(exception) instead for better performance
 */
@Deprecated("Use Logger.exception(exception) instead for better performance", ReplaceWith("Logger.exception(exception)"))
fun log(exception: Exception) {
    Log.exception(exception)
}
