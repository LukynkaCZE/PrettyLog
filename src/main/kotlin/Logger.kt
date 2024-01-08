import java.text.SimpleDateFormat
import java.util.*

object LoggerSettings {
    var saveToFile = true
    var saveDirectoryPath = "./logs/"
    var loggerStyle = LoggerStyle.PREFIX
    val logFileName: String = SimpleDateFormat("yyyy-MM-dd-Hms").format(Calendar.getInstance().time)
}

enum class LoggerStyle(val pattern: String) {
    FULL("<background><black><prefix>: <message>"),
    PREFIX("<background><black><prefix>:<reset> <foreground><message>"),
    SUFFIX("<foreground><prefix>: <background><black><message>"),
    TEXT_ONLY("<foreground><prefix>: <message>"),
}

fun log(message: String, type: CustomLogType = LogType.RUNTIME) {
    var pattern = LoggerSettings.loggerStyle.pattern
    pattern = pattern.replace("<background>", type.colorPair.background.code)
    pattern = pattern.replace("<foreground>", type.colorPair.foreground.code)
    pattern = pattern.replace("<black>", AnsiColor.BLACK.code)
    pattern = pattern.replace("<prefix>", type.name)
    pattern = pattern.replace("<message>", message)
    pattern = pattern.replace("<reset>", AnsiColor.RESET.code)

    println("$pattern${AnsiColor.RESET}")
    if(LoggerSettings.saveToFile) LoggerFileWriter.writeToFile(message, type)
}

fun log(exception: Exception) {
    log("$exception ${exception.cause.toString()}", LogType.EXCEPTION)
    exception.stackTrace.forEach {
        log("   $it", LogType.EXCEPTION)
    }
}