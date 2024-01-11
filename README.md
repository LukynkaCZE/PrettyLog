# PrettyLog

A Kotlin logging library focused on readability in console.
PrettyLog takes advantage of ANSI color codes to make your logs look ✨ ***pretty*** ✨.

## Logging
Logging is very easy, just call the `log(message, type)` method. `type` parameter is optional and defaults to `RUNTIME`
```kotlin
log("Hello there!")
log("general kenobi", LogType.NETWORK)
```
![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/4052e4f2-6b69-4e95-a2ee-ba130615d82f)


You can also log exceptions!
```kotlin
} catch (exception: Exception) {
    log(exception)
}
```
![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/a5268ff2-7736-43df-bfb0-2a82bfc6ecc3)

## Logger Settings
You can change settings by simply setting `LoggerSettings.<setting>` to its new value

```kotlin
// Should the logs be saved to file?
LoggerSettings.saveToFile = true
// The path to the logs directory
LoggerSettings.saveDirectoryPath = "./logs/"
// Format of the log file name
LoggerSettings.logFileNameFormat = "yyyy-MM-dd-Hms"
// Style of the logger in console
LoggerSettings.loggerStyle = LoggerStyle.PREFIX
```

### Logger Styles
There are 4 logger styles: **FULL**, **PREFIX**, **SUFFIX** and **TEXT_ONLY**

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/d6ac077f-506c-4b4e-b65f-bc1d7ce2ce40)

## Log Types
There are 8 default log types: **Debug**, **Information**, **Runtime**, **Network**, **Success**, **Warning**, **Error** and **Exception**

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/4b4385e7-7c55-4677-a791-bf88e6608140)

### Custom Log Types
You can make custom log types by making object and then making vals in it with `CustomLogType(name, AnsiPair)` data class

```kotlin
object CustomLogTypes {
    val CUTE = CustomLogType("≽^•⩊•^≼", AnsiPair.CUTE_PINK)
    val GIT = CustomLogType("\uD83E\uDD16 Git", AnsiPair.AQUA)
    val FIRE_WARNING = CustomLogType("\uD83D\uDD25 Fire Warning", AnsiPair.ORANGE)
}
```
```kotlin
log("T-This is vewy cuwute message OwO", CustomLogTypes.CUTE)
log("refusing to merge unrelated histories", CustomLogTypes.GIT)
log("SERVER ROOM ON FIRE, DONT LET ASO RUN WHILE LOOPS EVER AGAIN", CustomLogTypes.FIRE_WARNING)
```

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/93f82bab-1ccc-470b-8827-cfe4a1409a55)
