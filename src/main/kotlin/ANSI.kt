enum class AnsiColor(val code: String) {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    BLACK_BACKGROUND("\u001B[40m"),
    RED_BACKGROUND("\u001B[41m"),
    GREEN_BACKGROUND("\u001B[42m"),
    YELLOW_BACKGROUND("\u001B[43m"),
    BLUE_BACKGROUND("\u001B[44m"),
    PURPLE_BACKGROUND("\u001B[45m"),
    CYAN_BACKGROUND("\u001B[46m"),
    WHITE_BACKGROUND("\u001B[47m");

    override fun toString(): String {
        return code
    }
}
enum class AnsiPair(val background: AnsiColor, val foreground: AnsiColor) {
    RED(AnsiColor.RED_BACKGROUND, AnsiColor.RED),
    GREEN(AnsiColor.GREEN_BACKGROUND, AnsiColor.GREEN),
    YELLOW(AnsiColor.YELLOW_BACKGROUND, AnsiColor.YELLOW),
    BLUE(AnsiColor.BLUE_BACKGROUND, AnsiColor.BLUE),
    PURPLE(AnsiColor.PURPLE_BACKGROUND, AnsiColor.PURPLE),
    CYAN(AnsiColor.CYAN_BACKGROUND, AnsiColor.CYAN),
    WHITE(AnsiColor.WHITE_BACKGROUND, AnsiColor.WHITE)
}