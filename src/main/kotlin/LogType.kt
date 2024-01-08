object LogType {
    val INFORMATION = CustomLogType("ℹ\uFE0F Information", AnsiPair.CYAN)
    val RUNTIME = CustomLogType("✨ Runtime", AnsiPair.PINK)
    val NETWORK = CustomLogType("\uD83D\uDD0C Network", AnsiPair.BLUE)
    val SUCCESS = CustomLogType("✔\uFE0F Success", AnsiPair.GREEN)
    val WARNING = CustomLogType("⚠\uFE0F Warning", AnsiPair.YELLOW)
    val ERROR = CustomLogType("⛔ Error", AnsiPair.RED)
    val EXCEPTION = CustomLogType("\uD83D\uDCA3 Exception", AnsiPair.RED)
}

data class CustomLogType(
    val name: String,
    val colorPair: AnsiPair
)
