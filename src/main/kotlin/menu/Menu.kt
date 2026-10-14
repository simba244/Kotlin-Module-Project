package menu

class Menu {
    fun show(header: String, getItems: (exit: () -> Unit) -> List<MenuItem>) {
        var isRunning = true
        val exitCallback = { isRunning = false }

        while (isRunning) {
            val items = getItems(exitCallback)
            println("\n$header")
            items.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }
            print("Выберите пункт меню: ")
            val input = readlnOrNull()?.trim() ?: ""

            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Ошибка: следует вводить цифру. Попробуйте еще раз.")
                continue
            }

            if ((choice < 0) || (choice >= items.size)) {
                println("Ошибка: такой цифры нет в меню. Попробуйте еще раз.")
                continue
            }

            items[choice].action()
        }
    }
}
