import java.nio.file.FileSystemException

fun main() {
    LoggerFileWriter.load()

    log("Running main() in Demo.kt..", LogType.DEBUG)
    log("Very informative information", LogType.INFORMATION)
    log("I am running on time!", LogType.RUNTIME)
    log("Downloading maxwell.mp3", LogType.NETWORK)
    log("maxwell.mp3 has been downloaded!", LogType.SUCCESS)
    log("Warning.. file maxwell.mp3 may be corrupted!", LogType.WARNING)
    log("maxwell.mp3 cannot be played using IDrawableTrack", LogType.ERROR)
    try {
        val track = IDrawableTrack("maxwell.mp3")
        track.play()
    } catch (exception: Exception) {
        log(exception)
    }
}

class IDrawableTrack(private val file: String) {
    fun play() {
        throw FileSystemException("$file is not valid music file in the format of MP3!")
    }
}