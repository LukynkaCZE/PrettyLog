package cz.lukynka.prettylog.style

enum class AnsiColor(val code: String) {
    RESET("\u001B[0m"),
    BOLD("\u001B[1m"),

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    BRIGHT_BLACK("\u001B[90m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_BLUE("\u001B[94m"),
    BRIGHT_PURPLE("\u001B[95m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_WHITE("\u001B[97m"),

    BLACK_BACKGROUND("\u001B[40m"),
    RED_BACKGROUND("\u001B[41m"),
    GREEN_BACKGROUND("\u001B[42m"),
    YELLOW_BACKGROUND("\u001B[43m"),
    BLUE_BACKGROUND("\u001B[44m"),
    PURPLE_BACKGROUND("\u001B[45m"),
    CYAN_BACKGROUND("\u001B[46m"),
    WHITE_BACKGROUND("\u001B[47m"),

    BRIGHT_BLACK_BACKGROUND("\u001B[100m"),
    BRIGHT_RED_BACKGROUND("\u001B[101m"),
    BRIGHT_GREEN_BACKGROUND("\u001B[102m"),
    BRIGHT_YELLOW_BACKGROUND("\u001B[103m"),
    BRIGHT_BLUE_BACKGROUND("\u001B[104m"),
    BRIGHT_PURPLE_BACKGROUND("\u001B[105m"),
    BRIGHT_CYAN_BACKGROUND("\u001B[106m"),
    BRIGHT_WHITE_BACKGROUND("\u001B[107m"),

    GRAY(foreColor(244)),
    GRAY_BACKGROUND(backColor(244)),

    ORANGE(foreColor(202)),
    ORANGE_BACKGROUND(backColor(202)),

    PINK(foreColor(200)),
    PINK_BACKGROUND(backColor(200)),

    CUTE_PINK(foreColor(205)),
    CUTE_PINK_BACKGROUND(backColor(205)),

    AQUA(foreColor(45)),
    AQUA_BACKGROUND(backColor(45)),

    GOLD(foreColor(220)),
    GOLD_BACKGROUND(backColor(220)),

    LIGHT_GREEN(foreColor(82)),
    LIGHT_GREEN_BACKGROUND(backColor(82)),

    LIGHT_BLUE(foreColor(39)),
    LIGHT_BLUE_BACKGROUND(backColor(39)),

    MAGENTA(foreColor(13)),
    MAGENTA_BACKGROUND(backColor(13)),

    LIGHT_CYAN(foreColor(51)),
    LIGHT_CYAN_BACKGROUND(backColor(51)),

    LIGHT_GRAY(foreColor(247)),
    LIGHT_GRAY_BACKGROUND(backColor(247)),

    DARK_RED(foreColor(88)),
    DARK_RED_BACKGROUND(backColor(88)),

    DARK_GREEN(foreColor(22)),
    DARK_GREEN_BACKGROUND(backColor(22)),

    DARK_BLUE(foreColor(19)),
    DARK_BLUE_BACKGROUND(backColor(19)),

    DARK_YELLOW(foreColor(136)),
    DARK_YELLOW_BACKGROUND(backColor(136)),

    DARK_PURPLE(foreColor(55)),
    DARK_PURPLE_BACKGROUND(backColor(55));

    override fun toString(): String {
        return code
    }
}

fun foreColor(code: Int) = "\u001B[38;5;${code}m"
fun backColor(code: Int) = "\u001B[48;5;${code}m"