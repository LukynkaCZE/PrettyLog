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

    log("Critical issue detected in the payment system!", LogType.CRITICAL)
    log("User SkibidyToilet727 accessed the admin panel", LogType.AUDIT)
    log("Entering detailed trace mode for debugging", LogType.TRACE)
    log("Security breach attempt detected!", LogType.SECURITY)
    log("NeuroSama updated her profile picture to bread.png", LogType.USER_ACTION)
    log("Response time is 250ms", LogType.PERFORMANCE)
    log("MaxConnections set to 1000", LogType.CONFIG)
    log("Your life will be terminated", LogType.FATAL)

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