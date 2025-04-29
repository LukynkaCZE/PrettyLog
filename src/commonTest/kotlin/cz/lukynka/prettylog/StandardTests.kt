package cz.lukynka.prettylog

import kotlin.test.Test

class StandardTests {
    @Test
    fun testDebug() {
        log("Running testDebug() in StandardTests..", LogType.DEBUG)
    }

    @Test
    fun testInformation() {
        log("Very informative information", LogType.INFORMATION)
    }

    @Test
    fun testRuntime() {
        log("I am running on time!", LogType.RUNTIME)
    }

    @Test
    fun testNetwork() {
        log("Downloading maxwell.mp3", LogType.NETWORK)
    }

    @Test
    fun testSuccess() {
        log("maxwell.mp3 has been downloaded!", LogType.SUCCESS)
    }

    @Test
    fun testWarning() {
        log("Warning.. file maxwell.mp3 may be corrupted!", LogType.WARNING)
    }

    @Test
    fun testError() {
        log("maxwell.mp3 cannot be played using IDrawableTrack", LogType.ERROR)
    }

    @Test
    fun testCritical() {
        log("Critical issue detected in the payment system!", LogType.CRITICAL)
    }

    @Test
    fun testAudit() {
        log("User SkibidyToilet727 accessed the admin panel", LogType.AUDIT)
    }

    @Test
    fun testTrace() {
        log("Entering detailed trace mode for debugging", LogType.TRACE)
    }

    @Test
    fun testSecurity() {
        log("Security breach attempt detected!", LogType.SECURITY)
    }

    @Test
    fun testUserAction() {
        log("NeuroSama updated her profile picture to bread.png", LogType.USER_ACTION)
    }

    @Test
    fun testPerformance() {
        log("Response time is 250ms", LogType.PERFORMANCE)
    }

    @Test
    fun testConfig() {
        log("MaxConnections set to 1000", LogType.CONFIG)
    }

    @Test
    fun testFatal() {
        log("Your life will be terminated", LogType.FATAL)
    }
}

