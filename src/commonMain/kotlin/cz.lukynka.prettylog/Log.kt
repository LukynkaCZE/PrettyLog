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
    /**
     * Logs a debug message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun d(messageProvider: () -> String) = logInternal(messageProvider(), LogType.DEBUG)
    /**
     * Logs an information message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun i(messageProvider: () -> String) = logInternal(messageProvider(), LogType.INFORMATION)
    /**
     * Logs a runtime message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun r(messageProvider: () -> String) = logInternal(messageProvider(), LogType.RUNTIME)
    /**
     * Logs a network message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun n(messageProvider: () -> String) = logInternal(messageProvider(), LogType.NETWORK)
    /**
     * Logs a success message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun s(messageProvider: () -> String) = logInternal(messageProvider(), LogType.SUCCESS)
    /**
     * Logs a warning message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun w(messageProvider: () -> String) = logInternal(messageProvider(), LogType.WARNING)
    /**
     * Logs an error message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun e(messageProvider: () -> String) = logInternal(messageProvider(), LogType.ERROR)
    /**
     * Logs a critical message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun c(messageProvider: () -> String) = logInternal(messageProvider(), LogType.CRITICAL)
    /**
     * Logs an audit message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun a(messageProvider: () -> String) = logInternal(messageProvider(), LogType.AUDIT)
    /**
     * Logs a trace message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun t(messageProvider: () -> String) = logInternal(messageProvider(), LogType.TRACE)
    /**
     * Logs a security message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun sec(messageProvider: () -> String) = logInternal(messageProvider(), LogType.SECURITY)
    /**
     * Logs a user action message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun u(messageProvider: () -> String) = logInternal(messageProvider(), LogType.USER_ACTION)
    /**
     * Logs a performance message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun p(messageProvider: () -> String) = logInternal(messageProvider(), LogType.PERFORMANCE)
    /**
     * Logs a configuration message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun conf(messageProvider: () -> String) = logInternal(messageProvider(), LogType.CONFIG)
    /**
     * Logs a fatal message.
     * @param messageProvider A lambda that provides the message to log
     */
    fun f(messageProvider: () -> String) = logInternal(messageProvider(), LogType.FATAL)

    /**
     * Logs a message with a custom log type.
     * @param type The custom log type to use
     * @param messageProvider A lambda that provides the message to log
     */
    fun custom(type: CustomLogType, messageProvider: () -> String) = logInternal(messageProvider(), type)

    /**
     * @deprecated Use Log.exception { exception } instead for better performance
     */
    @Deprecated("Use Log.exception { exception } instead for better performance", ReplaceWith("Log.exception { exception }"))
    fun exception(exception: Exception) {
        exceptionInternal(exception)
    }

    /**
     * Logs an exception with stack trace.
     * @param exceptionProvider A lambda that provides the exception to log
     */
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
