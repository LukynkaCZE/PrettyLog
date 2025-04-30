package cz.lukynka.prettylog

import kotlin.test.Test

class StandardTests {
    @Test
    fun testDebug() {
        Log.d { "Running testDebug() in StandardTests.." }
    }

    @Test
    fun testInformation() {
        Log.i { "Very informative information" }
    }

    @Test
    fun testRuntime() {
        Log.r { "I am running on time!" }
    }

    @Test
    fun testNetwork() {
        Log.n { "Downloading maxwell.mp3" }
    }

    @Test
    fun testSuccess() {
        Log.s { "maxwell.mp3 has been downloaded!" }
    }

    @Test
    fun testWarning() {
        Log.w { "Warning.. file maxwell.mp3 may be corrupted!" }
    }

    @Test
    fun testError() {
        Log.e { "maxwell.mp3 cannot be played using IDrawableTrack" }
    }

    @Test
    fun testCritical() {
        Log.c { "Critical issue detected in the payment system!" }
    }

    @Test
    fun testAudit() {
        Log.a { "User SkibidyToilet727 accessed the admin panel" }
    }

    @Test
    fun testTrace() {
        Log.t { "Entering detailed trace mode for debugging" }
    }

    @Test
    fun testSecurity() {
        Log.sec { "Security breach attempt detected!" }
    }

    @Test
    fun testUserAction() {
        Log.u { "NeuroSama updated her profile picture to bread.png" }
    }

    @Test
    fun testPerformance() {
        Log.p { "Response time is 250ms" }
    }

    @Test
    fun testConfig() {
        Log.conf { "MaxConnections set to 1000" }
    }

    @Test
    fun testFatal() {
        Log.f { "Your life will be terminated" }
    }
}
