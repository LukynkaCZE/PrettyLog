enum class AnsiColor(val code: String) {
    RESET("\u001B[0m"),
    BLACK(foreColor(232)),

    GREEN(foreColor(40)),
    GREEN_BACKGROUND(backColor(40)),

    RED("\u001B[31m"),
    RED_BACKGROUND("\u001B[41m"),

    YELLOW(foreColor(220)),
    YELLOW_BACKGROUND(backColor(220)),

    ORANGE(foreColor(202)),
    ORANGE_BACKGROUND(backColor(202)),

    BLUE("\u001B[34m"),
    BLUE_BACKGROUND("\u001B[44m"),

    PURPLE("\u001B[35m"),
    PURPLE_BACKGROUND("\u001B[45m"),

    CUTE_PINK(foreColor(205)),
    CUTE_PINK_BACKGROUND(backColor(205)),

    PINK(foreColor(200)),
    PINK_BACKGROUND(backColor(200)),

    CYAN(foreColor(43)),
    CYAN_BACKGROUND(backColor(43)),

    AQUA(foreColor(45)),
    AQUA_BACKGROUND(backColor(45)),

    WHITE(foreColor(15)),
    WHITE_BACKGROUND(backColor(15));

    override fun toString(): String {
        return code
    }
}
enum class AnsiPair(val background: AnsiColor, val foreground: AnsiColor) {
    RED(AnsiColor.RED_BACKGROUND, AnsiColor.RED),
    GREEN(AnsiColor.GREEN_BACKGROUND, AnsiColor.GREEN),
    YELLOW(AnsiColor.YELLOW_BACKGROUND, AnsiColor.YELLOW),
    ORANGE(AnsiColor.ORANGE_BACKGROUND, AnsiColor.ORANGE),
    BLUE(AnsiColor.BLUE_BACKGROUND, AnsiColor.BLUE),
    PURPLE(AnsiColor.PURPLE_BACKGROUND, AnsiColor.PURPLE),
    CYAN(AnsiColor.CYAN_BACKGROUND, AnsiColor.CYAN),
    WHITE(AnsiColor.WHITE_BACKGROUND, AnsiColor.WHITE),
    AQUA(AnsiColor.AQUA_BACKGROUND, AnsiColor.AQUA),
    PINK(AnsiColor.PINK_BACKGROUND, AnsiColor.PINK),
    CUTE_PINK(AnsiColor.CUTE_PINK_BACKGROUND, AnsiColor.CUTE_PINK),
}

fun foreColor(code: Int) = "\u001B[38;5;${code}m"
fun backColor(code: Int) = "\u001B[48;5;${code}m"