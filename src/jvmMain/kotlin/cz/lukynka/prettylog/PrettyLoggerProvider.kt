package cz.lukynka.prettylog

import org.slf4j.ILoggerFactory
import org.slf4j.IMarkerFactory
import org.slf4j.helpers.NOPMDCAdapter
import org.slf4j.spi.MDCAdapter
import org.slf4j.spi.SLF4JServiceProvider

class PrettyLoggerProvider : SLF4JServiceProvider {
    companion object {
        const val REQUESTED_API_VERSION = "2.0.17"
    }

    private lateinit var prettyLoggerFactory: Slf4jPrettyLoggerFactory

    override fun getLoggerFactory(): ILoggerFactory = prettyLoggerFactory
    override fun getMarkerFactory(): IMarkerFactory? = null
    override fun getMDCAdapter(): MDCAdapter = NOPMDCAdapter()
    override fun getRequestedApiVersion(): String = REQUESTED_API_VERSION

    override fun initialize() {
        prettyLoggerFactory = Slf4jPrettyLoggerFactory()
    }
}