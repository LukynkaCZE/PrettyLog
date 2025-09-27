package cz.lukynka.prettylog

import cz.lukynka.prettylog.style.AnsiColor
import cz.lukynka.prettylog.style.DynamicLogPrefix
import cz.lukynka.prettylog.style.StaticLogPrefix
import cz.lukynka.prettylog.style.LogStyle
import kotlin.test.Test

class CustomLoggerTest {
    val proxyPrefix = StaticLogPrefix("✨ So Pretty ", LogStyle.FILLED_DARK_PURPLE)
//    val inboundPrefix = StaticLogPrefix("\uD83D\uDC9C So Handsome ", LogStyle.FILLED_BRIGHT_YELLOW)
    val inboundPrefix = DynamicLogPrefix(LogStyle.FILLED_BRIGHT_YELLOW) { "gay stuff" }
    val logger = PrettyLogger(inboundPrefix, proxyPrefix)

    @Test
    fun testCustom() {
        println()
        println()
        println()
        logger.log("beautiful log message..", LogType.RUNTIME)
        logger.log("oopsie", LogType.ERROR)
        println()
        println()
        println()
    }

    @Test
    fun test() {
        // Create custom log prefix
        val customLogStyle = LogStyle(textColor = AnsiColor.BLACK, backgroundColor = AnsiColor.CUTE_PINK_BACKGROUND)
        val customLogPrefix = StaticLogPrefix(" ≽^•⩊•^≼ ", customLogStyle)

        // Create custom log type
        val customLogType = LogType(textStyle = LogStyle.CUTE_PINK, listOf(customLogPrefix))

        println()
        println()
        println()
        log("T-This is vewy cuwute message OwO", customLogType)
        println()
        println()
        println()
    }
}