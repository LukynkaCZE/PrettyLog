[![wakatime](https://wakatime.com/badge/github/LukynkaCZE/PrettyLog.svg)](https://wakatime.com/badge/github/LukynkaCZE/PrettyLog)

# PrettyLog

A Kotlin logging library focused on readability in console.
PrettyLog takes advantage of ANSI color codes to make your logs look ✨ ***pretty*** ✨.

## Installation

<img src="https://cdn.worldvectorlogo.com/logos/kotlin-2.svg" width="16px"></img>
**Kotlin DSL**
```kotlin
repositories {
    maven {
        name = "devOS"
        url = uri("https://mvn.devos.one/releases")
    }
}

dependencies {
    implementation("cz.lukynka:pretty-log:1.4")
}
```
<img src="https://github.com/LukynkaCZE/PrettyLog/assets/48604271/3293feca-7395-4100-8b61-257ba40dbe3c" width="18px"></img>
**Gradle Groovy**
```groovy
repositories {
    mavenCentral()
    maven {
        name "devOS"
        url "https://mvn.devos.one/releases"
    }
}

dependencies {
    implementation 'cz.lukynka:pretty-log:1.4'
}
```
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
There are 7 logger styles in total:

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/17c8ab17-3003-4c5a-a4dd-91c0b08203f8)

## Log Types
There are 16 default log types: **Debug**, **Information**, **Runtime**, **Network**, **Success**, **Warning**, **Error**, **Exception**, **Critical**, **Audit**, **Trace**, **Security**, **User Action**, **Performance**, **Config**, and **Fatal**.

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/ee41b3a2-b2af-4ba8-a5d5-cfb7410b1065)

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
