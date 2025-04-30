package cz.lukynka.prettylog

import okio.IOException
import kotlin.test.Test
import kotlin.test.assertEquals

class IDrawableTrack(private val file: String) {
    fun play() {
        throw IOException("$file is not valid music file in the format of MP3!")
    }
}

class ExceptionTests {
    @Test
    fun testIOException() {
        try {
            val track = IDrawableTrack("maxwell.mp3")
            track.play()
        } catch (exception: Exception) {
            Log.exception { exception }
            assertEquals(exception.message, "maxwell.mp3 is not valid music file in the format of MP3!")
        }
    }
}
