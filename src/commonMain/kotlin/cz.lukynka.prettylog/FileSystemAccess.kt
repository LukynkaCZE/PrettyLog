package cz.lukynka.prettylog

import okio.Path

/**
 * Interface for platform-specific file system operations
 */
expect object FileSystemAccess {
    /**
     * Check if a directory exists at the given path
     */
    fun directoryExists(path: Path): Boolean
    
    /**
     * Create directories at the given path
     */
    fun createDirectories(path: Path)
    
    /**
     * Open a file for reading and writing, creating it if it doesn't exist
     */
    fun openReadWriteFile(path: Path, mustCreate: Boolean = false): FileHandleWrapper
    
    /**
     * Check if a file or directory exists at the given path
     */
    fun exists(path: Path): Boolean
    
    /**
     * Check if a path points to a directory
     */
    fun isDirectory(path: Path): Boolean
}

/**
 * Wrapper for platform-specific file handle
 */
expect class FileHandleWrapper {
    /**
     * Get a sink that appends to the file
     */
    fun appendingSink(): SinkWrapper
}

/**
 * Wrapper for platform-specific sink
 */
expect class SinkWrapper {
    /**
     * Write UTF-8 encoded text to the sink
     */
    fun writeUtf8(text: String): SinkWrapper
    
    /**
     * Flush the sink
     */
    fun flush(): SinkWrapper
}