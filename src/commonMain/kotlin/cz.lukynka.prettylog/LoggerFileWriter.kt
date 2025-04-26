package cz.lukynka.prettylog

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import okio.BufferedSink
import okio.FileHandle
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.buffer

object LoggerFileWriter {
    private var isLoaded = false
    private lateinit var file: FileHandle
    private lateinit var outputBuffer: BufferedSink
    private val logFileName: String = LocalDateTime.Format { @OptIn(FormatStringsInDatetimeFormats::class) byUnicodePattern(LoggerSettings.logFileNameFormat) }.format(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))

    // Store the logs that come before the FileWriter is loaded
    private var unloadedLogQueue = mutableListOf<Pair<String, CustomLogType>>()

    fun load() {
        if(isLoaded) {
            log("[PrettyLog] FileWriter is already loaded!", LogType.ERROR)
            return
        }

        // Create the directory if it doesn't exist
        if(!directoryExists(LoggerSettings.saveDirectoryPath)) {
            log(
                "[PrettyLog] Specified log directory (${LoggerSettings.saveDirectoryPath}) was not found, creating one..",
                LogType.WARNING
            )
            val path = LoggerSettings.saveDirectoryPath.toPath()
            FileSystem.SYSTEM.createDirectories(path)
            log("[PrettyLog] Log directory created!", LogType.SUCCESS)
        }

        //Make sure the path has the correct format
        if(!LoggerSettings.saveDirectoryPath.endsWith("/")) LoggerSettings.saveDirectoryPath += "/"
        file = FileSystem.SYSTEM.openReadWrite("${LoggerSettings.saveDirectoryPath}$logFileName.log".toPath(), mustCreate = true)
        outputBuffer = file.appendingSink().buffer()

        //Mark the FileWriter as loaded
        isLoaded = true

        //Write all logs that came before the FileWriter is loaded
        unloadedLogQueue.forEach { log -> writeToFile(log.first, log.second) }
    }

    fun writeToFile(message: String, type: CustomLogType) {
        if(!isLoaded) {
            unloadedLogQueue.add(Pair(message, type))
            return
        }
        val date = LocalDateTime.Format { @OptIn(FormatStringsInDatetimeFormats::class) byUnicodePattern("yyyy-MM-dd HH:mm:ss") }.format(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()))
        outputBuffer.writeUtf8("$date [${type.name.uppercase()}] $message\n").flush()
    }
}

fun directoryExists(directoryPath: String): Boolean {
    val path: Path = directoryPath.toPath()
    return FileSystem.SYSTEM.exists(path) && FileSystem.SYSTEM.metadata(path).isDirectory
}