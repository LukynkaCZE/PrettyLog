package cz.lukynka.prettylog

import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class Slf4jPrettyLoggerFactory : ILoggerFactory {
    override fun getLogger(name: String): Logger = Slf4jPrettyLogger(name)
}