package cz.lukynka.prettylog

import org.slf4j.LoggerFactory
import kotlin.test.Test

class Slf4jTests {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun testTrace() = logger.trace("Testing trace() in Slf4jTests.")

    @Test
    fun testDebug() = logger.debug("Testing debug() in Slf4jTests.")

    @Test
    fun testInfo() = logger.info("Testing info() in Slf4jTests.")

    @Test
    fun testWarn() = logger.warn("Testing warn() in Slf4jTests.")

    @Test
    fun testError() = logger.error("Testing error() in Slf4jTests.")
}