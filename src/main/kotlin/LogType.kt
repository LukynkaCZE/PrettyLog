object LogType {
    val INFORMATION = CustomLogType("Information", AnsiPair.CYAN)
    val RUNTIME = CustomLogType("Runtime", AnsiPair.PURPLE)
    val NETWORK = CustomLogType("Network", AnsiPair.BLUE)
    val SUCCESS = CustomLogType("Success", AnsiPair.GREEN)
    val WARNING = CustomLogType("Warning", AnsiPair.YELLOW)
    val ERROR = CustomLogType("Error", AnsiPair.RED)
    val EXCEPTION = CustomLogType("Exception", AnsiPair.RED)
}

data class CustomLogType(
    val name: String,
    val colorPair: AnsiPair
)
