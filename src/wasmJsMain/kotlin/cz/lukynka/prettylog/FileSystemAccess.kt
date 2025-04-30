package cz.lukynka.prettylog

import okio.Path

actual object FileSystemAccess {
    // In-memory storage for logs
    private val logs = mutableListOf<String>()

    actual fun directoryExists(path: Path): Boolean {
        // Always return true for WasmJS - we'll simulate directory existence
        return true
    }

    actual fun createDirectories(path: Path) {
        // No-op for WasmJS - we don't actually create directories
        logs.add("[PrettyLog] Would create directory: $path")
    }

    actual fun openReadWriteFile(path: Path, mustCreate: Boolean): FileHandleWrapper {
        logs.add("[PrettyLog] Would open file: $path")
        return FileHandleWrapper()
    }

    actual fun exists(path: Path): Boolean {
        // Always return true for WasmJS - we'll simulate file existence
        return true
    }

    actual fun isDirectory(path: Path): Boolean {
        // Always return true for WasmJS - we'll simulate directory status
        return true
    }

    // Method to get all logs (for debugging)
    fun getAllLogs(): List<String> {
        return logs.toList()
    }

    // Method to add a log entry
    internal fun addLog(log: String) {
        logs.add(log)
    }
}

actual class FileHandleWrapper {
    actual fun appendingSink(): SinkWrapper {
        return SinkWrapper()
    }
}

actual class SinkWrapper {
    private var buffer = ""

    actual fun writeUtf8(text: String): SinkWrapper {
        buffer += text
        return this
    }

    actual fun flush(): SinkWrapper {
        if (buffer.isNotEmpty()) {
            FileSystemAccess.addLog(buffer)
            buffer = ""
        }
        return this
    }
}
