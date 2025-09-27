
# 🌈 PrettyLog ✨
[![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmvn.devos.one%2Freleases%2Fcz%2Flukynka%2Fpretty-log-common%2Fmaven-metadata.xml&style=for-the-badge&logo=maven&logoColor=%23FFFFFF&label=Latest%20Version&color=%23afff87)](https://mvn.devos.one/#/releases/io/github/dockyardmc/dockyard)
[![wakatime](https://wakatime.com/badge/github/LukynkaCZE/PrettyLog.svg?style=for-the-badge)](https://wakatime.com/badge/github/LukynkaCZE/PrettyLog)
[![Language](https://img.shields.io/badge/Language-Kotlin-Kotlin?style=for-the-badge&color=%23ff6969)](https://kotlinlang.org/)


A Kotlin logging library focused on readability in console.
PrettyLog takes advantage of ANSI color codes to make your logs look ✨ ***pretty*** ✨.

<img width="716" height="80" alt="image" src="https://github.com/user-attachments/assets/5b8e6ddc-3e4b-4107-8e54-e579bfc6dfc3" />

## Installation

As of 2.0, PrettyLog supports the following targets:

- `jvm` (Java 21)
- `mingwx64` (Windows)
- `macosx64`
- `macosarm64`
- `linuxx64`
- `linuxarm64`

Supporting both Kotlin/JVM and Kotlin/Native

<img src="https://cdn.worldvectorlogo.com/logos/kotlin-2.svg" width="16px"></img>
**Kotlin**
```kotlin
repositories {
    maven("https://mvn.devos.one/releases")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
    implementation("com.squareup.okio:okio:3.10.2")

    // Import the common code
    implementation("cz.lukynka:pretty-log-common:<version>")

    // Import the platform-specific library. Do jvm if you're doing Kotlin/JVM / Java, 
    // Do any other platform if you're doing Kotlin/Native [like linuxx64 or mingwx64]
    implementation("cz.lukynka:pretty-log-PLATFORMNAMEHERE:<version>")
}
```


## Logging
Logging is very easy, just call the `log(message, type)` method. `type` parameter is optional and defaults to `RUNTIME`. Add `LoggerFileWriter.load()` to your main function if you want logs to be saved.
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
PrettyLogSettings.saveToFile = true
// The path to the logs directory
PrettyLogSettings.saveDirectoryPath = "./logs/"
// Format of the log file name
PrettyLogSettings.logFileNameFormat = "yyyy-MM-dd-Hms"
// Logs which will be disabled and not show up
PrettyLogSettings.disabledLogTypes = setOf(LogType.WARNING)
```

## Log Types
There are 16 log types by default:

![image](https://github.com/LukynkaCZE/PrettyLog/assets/48604271/ee41b3a2-b2af-4ba8-a5d5-cfb7410b1065)

You can make custom log types by making your own `LogType` instance. Everything from the prefix background color, text color to the actual message text color is customizable

```kotlin
// Create custom log prefix
val customLogStyle = LogStyle(textColor = AnsiColor.BLACK, backgroundColor = AnsiColor.CUTE_PINK_BACKGROUND)
val customLogPrefix = StaticLogPrefix(" ≽^•⩊•^≼ ", customLogStyle)

// Create custom log type
val customLogType = LogType(textStyle = LogStyle.CUTE_PINK, listOf(customLogPrefix))

log("T-This is vewy cuwute message OwO", customLogType)
```

<img width="490" height="86" alt="image" src="https://github.com/user-attachments/assets/7c8a1f30-93c8-4211-b906-e1b36fda2032" />

There is also  `DynamicLogPrefix` which has field for text supplier instead of static string.

You may alternatively use simpler version of this for class-specific logger by referencing the class in the constructor:

```kotlin
val logger = PrettyLogger(this::class)
```

<img width="791" height="63" alt="image" src="https://github.com/user-attachments/assets/5a347354-92d8-40cc-ad45-252e9219d1b8" />


## Loggers with custom prefixes

You can add multiple prefixes to a custom logger. For example, we can add "Inbound" prefix and a "Proxy" for better understanding what is being logged and from where
```kotlin
val proxyPrefix = StaticLogPrefix(" Proxy ", LogStyle.FILLED_PURPLE)
val inboundPrefix = StaticLogPrefix("-> Inbound ", LogStyle.GRAY)
// create custom instance of PrettyLogger
val logger = PrettyLogger(inboundPrefix, proxyPrefix)


Events.on<PacketReceivedEvent> { event ->
    logger.log(event.packet.name, LogType.NETWORK)
}
```

<img width="731" height="121" alt="image" src="https://github.com/user-attachments/assets/e0718309-48fc-4483-b8db-99502ae44aa9" />


## Implementations in other languages

- C#: https://github.com/dalibor-osu/PrettyLogSharp by [dalibor-osu](https://github.com/dalibor-osu)
