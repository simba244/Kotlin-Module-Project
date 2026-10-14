package menu

import model.Note

class NoteScreen(
    private val note: Note,
    private val menu: Menu,
) {
    fun start() {
        menu.show("Экран заметки '${note.title}':") { exit ->
            listOf(
                MenuItem("Посмотреть текст заметки") {
                    println("\n=== ${note.title} ===")
                    println(note.content)
                    println("=====================")
                },
                MenuItem("Назад") { exit() },
            )
        }
    }
}
