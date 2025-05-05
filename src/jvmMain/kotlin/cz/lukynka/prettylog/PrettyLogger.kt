package cz.lukynka.prettylog

import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.helpers.MessageFormatter

// TODO Implement SLF4J Marker support.

class PrettyLogger(val name: String) : Logger {
    override fun getName(): String = this.name

    //region Trace
    override fun isTraceEnabled(): Boolean = true

    override fun trace(msg: String) = log(msg, LogType.TRACE)

    override fun trace(format: String, arg: Any) = log(MessageFormatter.format(format, arg).message,  LogType.TRACE)

    override fun trace(format: String, arg1: Any, arg2: Any) = log(MessageFormatter.format(format, arg1, arg2).message,  LogType.TRACE)

    override fun trace(format: String, vararg arguments: Any) = log(MessageFormatter.format(format, arguments).message,  LogType.TRACE)

    override fun trace(msg: String, t: Throwable?) = log(Exception(msg, t))

    override fun isTraceEnabled(marker: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker, msg: String) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker, format: String, arg: Any) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker, format: String, arg1: Any, arg2: Any) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker, format: String, vararg argArray: Any) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker, msg: String, t: Throwable) {
        TODO("Not yet implemented")
    }
    //endregion

    //region Debug
    override fun isDebugEnabled(): Boolean = true

    override fun debug(msg: String) = log(msg, LogType.DEBUG)

    override fun debug(format: String, arg: Any) = log(MessageFormatter.format(format, arg).message, LogType.DEBUG)

    override fun debug(format: String, arg1: Any, arg2: Any) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.DEBUG)

    override fun debug(format: String, vararg arguments: Any) = log(MessageFormatter.format(format, arguments).message, LogType.DEBUG)

    override fun debug(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isDebugEnabled(marker: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker, msg: String) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker, format: String, arg: Any) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker, format: String, arg1: Any, arg2: Any) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker, format: String, vararg arguments: Any) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker, msg: String, t: Throwable) {
        TODO("Not yet implemented")
    }
    //endregion

    //region Info
    override fun isInfoEnabled(): Boolean = true

    override fun info(msg: String) = log(msg, LogType.INFORMATION)

    override fun info(format: String, arg: Any) = log(MessageFormatter.format(format, arg).message, LogType.INFORMATION)

    override fun info(format: String, arg1: Any, arg2: Any) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.INFORMATION)

    override fun info(format: String, vararg arguments: Any) = log(MessageFormatter.format(format, arguments).message, LogType.INFORMATION)

    override fun info(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isInfoEnabled(marker: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker, msg: String) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker, format: String, arg: Any) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker, format: String, arg1: Any, arg2: Any) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker, format: String, vararg arguments: Any) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker, msg: String, t: Throwable) {
        TODO("Not yet implemented")
    }
    //endregion

    //region Warn
    override fun isWarnEnabled(): Boolean = true

    override fun warn(msg: String) = log(msg, LogType.WARNING)

    override fun warn(format: String, arg: Any) = log(MessageFormatter.format(format, arg).message, LogType.WARNING)

    override fun warn(format: String, vararg arguments: Any) = log(MessageFormatter.format(format, arguments).message, LogType.WARNING)

    override fun warn(format: String, arg1: Any, arg2: Any) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.WARNING)

    override fun warn(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isWarnEnabled(marker: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker, msg: String) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker, format: String, arg: Any) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker, format: String, arg1: Any, arg2: Any) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker, format: String, vararg arguments: Any) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker, msg: String, t: Throwable) {
        TODO("Not yet implemented")
    }
    //endregion

    //region Error
    override fun isErrorEnabled(): Boolean = true

    override fun error(msg: String) = log(msg, LogType.ERROR)

    override fun error(format: String, arg: Any) = log(MessageFormatter.format( format, arg).message, LogType.ERROR)

    override fun error(format: String, arg1: Any, arg2: Any) = log(MessageFormatter.format( format, arg1, arg2).message, LogType.ERROR)

    override fun error(format: String, vararg arguments: Any) = log(MessageFormatter.format(format, arguments).message, LogType.ERROR)

    override fun error(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isErrorEnabled(marker: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker, msg: String) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker, format: String, arg: Any) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker, format: String, arg1: Any, arg2: Any) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker, format: String, vararg arguments: Any) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker, msg: String, t: Throwable) {
        TODO("Not yet implemented")
    }
    //endregion
}