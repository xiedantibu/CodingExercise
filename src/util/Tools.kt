package util.tools

fun <T : Any> T.println() = kotlin.io.println(this)
fun <T : Any> T.print() = kotlin.io.print(this)

