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

    @Test
    fun testShowTimeToggle() {
        // Save original setting
        val originalShowTime = LoggerSettings.showTime

        // Test with time shown (default)
        LoggerSettings.showTime = true
        Log.i { "This message should show time" }

        // Test with time hidden
        LoggerSettings.showTime = false
        Log.i { "This message should NOT show time" }

        // Restore original setting
        LoggerSettings.showTime = originalShowTime
    }

    @Test
    fun testSeverityFiltering() {
        // Save original setting
        val originalSeverity = LoggerSettings.minimumSeverity

        // Set minimum severity to WARNING
        LoggerSettings.minimumSeverity = LogSeverity.WARNING

        println("--- Testing with minimum severity set to WARNING ---")

        // These should NOT be logged (below WARNING)
        Log.d { "This DEBUG message should NOT be logged" }
        Log.i { "This INFO message should NOT be logged" }

        // These should be logged (WARNING or above)
        Log.w { "This WARNING message should be logged" }
        Log.e { "This ERROR message should be logged" }
        Log.f { "This FATAL message should be logged" }

        // Set minimum severity to ERROR
        LoggerSettings.minimumSeverity = LogSeverity.ERROR

        println("--- Testing with minimum severity set to ERROR ---")

        // These should NOT be logged (below ERROR)
        Log.d { "This DEBUG message should NOT be logged" }
        Log.i { "This INFO message should NOT be logged" }
        Log.w { "This WARNING message should NOT be logged" }

        // These should be logged (ERROR or above)
        Log.e { "This ERROR message should be logged" }
        Log.f { "This FATAL message should be logged" }

        // Restore original setting
        LoggerSettings.minimumSeverity = originalSeverity
    }
}
