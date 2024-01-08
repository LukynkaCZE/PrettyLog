import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*

object LoggerFileWriter {
    var isLoaded = false
    lateinit var file: File

    // Store the logs that come before the FileWriter is loaded
    var unloadedLogQueue = mutableListOf<Pair<String, CustomLogType>>()

    fun load() {
        if(isLoaded) {
            log("[PrettyLog] FileWriter is already loaded!", LogType.ERROR)
            return
        }

        //Make sure the path has the correct format
        if(!LoggerSettings.saveDirectoryPath.endsWith("/")) LoggerSettings.saveDirectoryPath += "/"
        file = File("${LoggerSettings.saveDirectoryPath}${LoggerSettings.logFileName}.log")

        // Create the directory if it doesn't exist
        if(!directoryExists(LoggerSettings.saveDirectoryPath)) {
            log("[PrettyLog] Specified log directory (${LoggerSettings.saveDirectoryPath}) was not found, creating one..", LogType.WARNING)
            val path = Paths.get(LoggerSettings.saveDirectoryPath)
            Files.createDirectories(path)
            log("[PrettyLog] Log directory created!", LogType.SUCCESS)
        }

        // Create the file if it doesn't exist
        if(!file.exists()) file.createNewFile()

        //Mark the FileWriter as loaded
        isLoaded = true

        //Write all logs that came before the FileWriter is loaded
        unloadedLogQueue.forEach { writeToFile(it.first, it.second) }
    }

    fun writeToFile(message: String, type: CustomLogType) {
        if(!isLoaded) {
            unloadedLogQueue.add(Pair(message, type))
            return
        }
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().time)
        file.writeText("${file.readText()}$date [${type.name.uppercase()}] $message\n")
    }
}

fun directoryExists(directoryPath: String): Boolean {
    val path: Path = Paths.get(directoryPath)
    return Files.exists(path) && Files.isDirectory(path)
}