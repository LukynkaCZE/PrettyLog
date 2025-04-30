package cz.lukynka.prettylog

import okio.*

actual object FileSystemAccess {
    actual fun directoryExists(path: Path): Boolean {
        return FileSystem.SYSTEM.exists(path) && FileSystem.SYSTEM.metadata(path).isDirectory
    }
    
    actual fun createDirectories(path: Path) {
        FileSystem.SYSTEM.createDirectories(path)
    }
    
    actual fun openReadWriteFile(path: Path, mustCreate: Boolean): FileHandleWrapper {
        val fileHandle = FileSystem.SYSTEM.openReadWrite(path, mustCreate)
        return FileHandleWrapper(fileHandle)
    }
    
    actual fun exists(path: Path): Boolean {
        return FileSystem.SYSTEM.exists(path)
    }
    
    actual fun isDirectory(path: Path): Boolean {
        return FileSystem.SYSTEM.metadata(path).isDirectory
    }
}

actual class FileHandleWrapper(private val fileHandle: FileHandle) {
    actual fun appendingSink(): SinkWrapper {
        return SinkWrapper(fileHandle.appendingSink().buffer())
    }
}

actual class SinkWrapper(private val sink: BufferedSink) {
    actual fun writeUtf8(text: String): SinkWrapper {
        sink.writeUtf8(text)
        return this
    }
    
    actual fun flush(): SinkWrapper {
        sink.flush()
        return this
    }
}