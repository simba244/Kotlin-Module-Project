package util

object InputUtils {
    fun readNonEmptyString(
        prompt: String,
        errorMessage: String,
    ): String {
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.trim() ?: ""
            if (input.isNotEmpty()) {
                return input
            }
            println("Ошибка: $errorMessage")
        }
    }
}
