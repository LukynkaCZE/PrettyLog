package cz.lukynka.prettylog

import cz.lukynka.prettylog.style.AnsiColor
import cz.lukynka.prettylog.style.LogPrefix
import cz.lukynka.prettylog.style.LogStyle
import kotlin.test.Test

class CustomLoggerTest {
    val proxyPrefix = LogPrefix("\uD83C\uDF0D Proxy ", LogStyle.FILLED_PURPLE)
    val inboundPrefix = LogPrefix("-> Inbound ", LogStyle.GRAY)
    val logger = PrettyLogger(inboundPrefix, proxyPrefix)

    @Test
    fun testCustom() {
        logger.log("ServerboundHandshakePacket", LogType.NETWORK)
        logger.log("ServerboundLoginStartPacket", LogType.NETWORK)
        logger.log("ServerboundEncryptionResponsePacket", LogType.NETWORK)
    }

    @Test
    fun test() {
        // Create custom log prefix
        val customLogStyle = LogStyle(textColor = AnsiColor.BLACK, backgroundColor = AnsiColor.CUTE_PINK_BACKGROUND)
        val customLogPrefix = LogPrefix(" ≽^•⩊•^≼ ", customLogStyle)

        // Create custom log type
        val customLogType = LogType(textStyle = LogStyle.CUTE_PINK, listOf(customLogPrefix))

        log("T-This is vewy cuwute message OwO", customLogType)
    }
}