# PrettyLog

A Kotlin logging library focused on readability in console.
PrettyLog takes advantage of ANSI color codes to make your logs look ✨ ***pretty*** ✨.

## Logging
Logging is very easy, just call the `log(message, type)` method. `type` parameter is optional and defaults to `RUNTIME`
```kotlin
log("Hello there!")
log("general kenobi", LogType.NETWORK)
```
![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/7aad7a44-ced4-4049-9932-9c5a81f80b22)

You can also log exceptions!
```kotlin
} catch (exception: Exception) {
    log(exception)
}
```
![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/da48c24b-7846-47b1-82ce-df50d331b07d)

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
![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/c264859f-c082-45d0-9f81-5743c744ebdd)

## Log Types
There are 7 default log types: **Information**, **Runtime**, **Network**, **Success**, **Warning**, **Error** and **Exception**

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/9fea58ff-5441-4b5b-974f-810f91237dfc)

### Custom Log Types
You can make custom log types by making object and then making vals in it with `CustomLogType(name, AnsiPair)` data class

```kotlin
object CustomLogTypes {
    val CUSTOM = CustomLogType("Very Custom Log Type", AnsiPair.YELLOW)
    val GIT = CustomLogType("Git", AnsiPair.WHITE)
}
```
```kotlin
log("Very Custom Log Type!!!!", CustomLogTypes.CUSTOM)
log("refusing to merge unrelated histories", CustomLogTypes.GIT)
```

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/6ae1251f-1e30-41f4-9eea-9b06b6bb82f8)


## 
