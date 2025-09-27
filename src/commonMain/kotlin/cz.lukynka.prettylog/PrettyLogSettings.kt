package cz.lukynka.prettylog

object PrettyLogSettings {
    var saveToFile: Boolean = true
    var saveDirectoryPath: String = "./logs/"
    var logFileNameFormat: String = "yyyy-MM-dd-HHmmss"
    var disabledLogTypes: Set<LogType> = setOf()
}