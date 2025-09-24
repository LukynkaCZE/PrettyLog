package cz.lukynka.prettylog

import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.helpers.MessageFormatter

class PrettyLogger(val loggerName: String) : Logger {

    override fun getName(): String = this.loggerName

    //region Trace
    override fun isTraceEnabled(): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.TRACE)

    override fun trace(msg: String) = log(msg, LogType.TRACE)

    override fun trace(format: String, arg: Any?) = log(MessageFormatter.format(format, arg).message,  LogType.TRACE)

    override fun trace(format: String, arg1: Any?, arg2: Any?) = log(MessageFormatter.format(format, arg1, arg2).message,  LogType.TRACE)

    override fun trace(format: String, vararg arguments: Any?) = log(MessageFormatter.arrayFormat(format, arguments).message,  LogType.TRACE)

    override fun trace(msg: String, t: Throwable?) = log(Exception(msg, t))

    override fun isTraceEnabled(marker: Marker): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.TRACE)

    override fun trace(marker: Marker, msg: String) = trace("${marker.name}: $msg")

    override fun trace(marker: Marker, format: String, arg: Any?) = trace("${marker.name}: $format", arg)

    override fun trace(marker: Marker, format: String, arg1: Any?, arg2: Any?) = trace("${marker.name}: $format", arg1, arg2)

    override fun trace(marker: Marker, format: String, vararg argArray: Any?) = trace("${marker.name}: $format", *argArray)

    override fun trace(marker: Marker, msg: String, t: Throwable) = trace("${marker.name}: $msg", t)
    //endregion

    //region Debug
    override fun isDebugEnabled(): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.DEBUG)

    override fun debug(msg: String) = log(msg, LogType.DEBUG)

    override fun debug(format: String, arg: Any?) = log(MessageFormatter.format(format, arg).message, LogType.DEBUG)

    override fun debug(format: String, arg1: Any?, arg2: Any?) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.DEBUG)

    override fun debug(format: String, vararg arguments: Any?) = log(MessageFormatter.arrayFormat(format, arguments).message, LogType.DEBUG)

    override fun debug(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isDebugEnabled(marker: Marker): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.DEBUG)

    override fun debug(marker: Marker, msg: String) = debug("${marker.name}: $msg")

    override fun debug(marker: Marker, format: String, arg: Any?) = debug("${marker.name}: $format", arg)

    override fun debug(marker: Marker, format: String, arg1: Any?, arg2: Any?) = debug("${marker.name}: $format", arg1, arg2)

    override fun debug(marker: Marker, format: String, vararg argArray: Any?) = debug("${marker.name}: $format", *argArray)

    override fun debug(marker: Marker, msg: String, t: Throwable) = debug("${marker.name}: $msg", t)
    //endregion

    //region Info
    override fun isInfoEnabled(): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.INFORMATION)

    override fun info(msg: String) = log(msg, LogType.INFORMATION)

    override fun info(format: String, arg: Any?) = log(MessageFormatter.format(format, arg).message, LogType.INFORMATION)

    override fun info(format: String, arg1: Any?, arg2: Any?) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.INFORMATION)

    override fun info(format: String, vararg arguments: Any?) = log(MessageFormatter.arrayFormat(format, arguments).message, LogType.INFORMATION)

    override fun info(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isInfoEnabled(marker: Marker): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.INFORMATION)

    override fun info(marker: Marker, msg: String) = info("${marker.name}: $msg")

    override fun info(marker: Marker, format: String, arg: Any?) = info("${marker.name}: $format", arg)

    override fun info(marker: Marker, format: String, arg1: Any?, arg2: Any?) = info("${marker.name}: $format", arg1, arg2)

    override fun info(marker: Marker, format: String, vararg argArray: Any?) = info("${marker.name}: $format", *argArray)

    override fun info(marker: Marker, msg: String, t: Throwable) = info("${marker.name}: $msg", t)
    //endregion

    //region Warn
    override fun isWarnEnabled(): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.WARNING)

    override fun warn(msg: String) = log(msg, LogType.WARNING)

    override fun warn(format: String, arg: Any?) = log(MessageFormatter.format(format, arg).message, LogType.WARNING)

    override fun warn(format: String, arg1: Any?, arg2: Any?) = log(MessageFormatter.format(format, arg1, arg2).message, LogType.WARNING)

    override fun warn(format: String, vararg arguments: Any?) = log(MessageFormatter.arrayFormat(format, arguments).message, LogType.WARNING)

    override fun warn(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isWarnEnabled(marker: Marker): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.WARNING)

    override fun warn(marker: Marker, msg: String) = warn("${marker.name}: $msg")

    override fun warn(marker: Marker, format: String, arg: Any?) = warn("${marker.name}: $format", arg)

    override fun warn(marker: Marker, format: String, arg1: Any?, arg2: Any?) = warn("${marker.name}: $format", arg1, arg2)

    override fun warn(marker: Marker, format: String, vararg argArray: Any?) = warn("${marker.name}: $format", *argArray)

    override fun warn(marker: Marker, msg: String, t: Throwable) = warn("${marker.name}: $msg", t)
    //endregion

    //region Error
    override fun isErrorEnabled(): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.ERROR)

    override fun error(msg: String) = log(msg, LogType.ERROR)

    override fun error(format: String, arg: Any?) = log(MessageFormatter.format( format, arg).message, LogType.ERROR)

    override fun error(format: String, arg1: Any?, arg2: Any?) = log(MessageFormatter.format( format, arg1, arg2).message, LogType.ERROR)

    override fun error(format: String, vararg arguments: Any?) = log(MessageFormatter.arrayFormat(format, arguments).message, LogType.ERROR)

    override fun error(msg: String, t: Throwable) = log(Exception(msg, t))

    override fun isErrorEnabled(marker: Marker): Boolean = !LoggerSettings.disabledLogTypes.contains(LogType.ERROR)

    override fun error(marker: Marker, msg: String) = error("${marker.name}: $msg")

    override fun error(marker: Marker, format: String, arg: Any?) = error("${marker.name}: $format", arg)

    override fun error(marker: Marker, format: String, arg1: Any?, arg2: Any?) = error("${marker.name}: $format", arg1, arg2)

    override fun error(marker: Marker, format: String, vararg arguments: Any?) = error("${marker.name}: $format", *arguments)

    override fun error(marker: Marker, msg: String, t: Throwable) = error("${marker.name}: $msg", t)
    //endregion
}