package cz.lukynka.prettylog

import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class PrettyLoggerFactory : ILoggerFactory {
    override fun getLogger(name: String): Logger = PrettyLogger(name)

}