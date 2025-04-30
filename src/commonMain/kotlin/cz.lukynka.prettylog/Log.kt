package cz.lukynka.prettylog

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime

object LoggerSettings {
    var saveToFile = true
    var saveDirectoryPath = "./logs/"
    var loggerStyle = LoggerStyle.PREFIX
    var logFileNameFormat = "yyyy-MM-dd-HHmmss"
    var logTimeFormat = "HH:mm:ss"
}

enum class LoggerStyle(val pattern: String) {
    FULL("<background><black><emoji> <time> <type>: <message>"),
    PREFIX("<background><black><emoji> <time> <type>:<reset> <foreground><message>"),
    SUFFIX("<foreground><emoji> <time> <type>: <background><black><message>"),
    TEXT_ONLY("<foreground><emoji> <time> <type>: <message>"),
    PREFIX_WHITE_TEXT("<background><black><emoji> <time> <type>:<reset> <message>"),
    BRACKET_PREFIX("<foreground><bold>[<emoji> <time> <type>]<reset><foreground> <message>"),
    BRACKET_PREFIX_WHITE_TEXT("<foreground><bold>[<emoji> <time> <type>] <reset><message>")
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

        // Extract emoji and type name
        val emojiAndType = extractEmojiAndType(type.name)
        val emoji = emojiAndType.first
        val typeName = emojiAndType.second

        // Get current time
        val currentTime = getCurrentTime()

        pattern = pattern.replace("<background>", type.colorPair.background.code)
        pattern = pattern.replace("<foreground>", type.colorPair.foreground.code)
        pattern = pattern.replace("<black>", AnsiColor.BLACK.code)
        pattern = pattern.replace("<emoji>", emoji)
        pattern = pattern.replace("<time>", currentTime)
        pattern = pattern.replace("<type>", typeName)
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

    // Extract emoji and type name
    val emojiAndType = extractEmojiAndType(type.name)
    val emoji = emojiAndType.first
    val typeName = emojiAndType.second

    // Get current time
    val currentTime = getCurrentTime()

    pattern = pattern.replace("<background>", type.colorPair.background.code)
    pattern = pattern.replace("<foreground>", type.colorPair.foreground.code)
    pattern = pattern.replace("<black>", AnsiColor.BLACK.code)
    pattern = pattern.replace("<emoji>", emoji)
    pattern = pattern.replace("<time>", currentTime)
    pattern = pattern.replace("<type>", typeName)
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

/**
 * Extracts emoji and type name from the full name
 * @param fullName The full name including emoji and type
 * @return Pair of emoji and type name
 */
internal fun extractEmojiAndType(fullName: String): Pair<String, String> {
    // Find the first space which separates emoji and type name
    val spaceIndex = fullName.indexOf(' ')
    if (spaceIndex == -1) return Pair("", fullName)

    val emoji = fullName.substring(0, spaceIndex)
    val typeName = fullName.substring(spaceIndex + 1)
    return Pair(emoji, typeName)
}

/**
 * Gets the current time formatted according to settings
 * @return Formatted current time
 */
internal fun getCurrentTime(): String {
    return LocalDateTime.Format { 
        @OptIn(FormatStringsInDatetimeFormats::class) 
        byUnicodePattern(LoggerSettings.logTimeFormat) 
    }.format(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))
}
