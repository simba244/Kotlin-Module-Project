package menu

import model.Archive
import model.Note
import util.InputUtils

class NoteMenu(
    private val archive: Archive,
    private val menu: Menu,
) {
    fun start() {
        menu.show("Список заметок архива '${archive.name}':") { exit ->
            val list = mutableListOf<MenuItem>()
            list.add(MenuItem("Создать заметку") { createNote() })
            archive.notes.forEach { note ->
                list.add(MenuItem(note.title) { openNote(note) })
            }
            list.add(MenuItem("Назад") { exit() })
            list
        }
    }

    private fun createNote() {
        println("\n--- Создание заметки ---")
        val title = InputUtils.readNonEmptyString(
            prompt = "Введите название заметки: ",
            errorMessage = "Название заметки не может быть пустым."
        )
        val content = InputUtils.readNonEmptyString(
            prompt = "Введите текст заметки: ",
            errorMessage = "Текст заметки не может быть пустым."
        )
        archive.notes.add(Note(title, content))
        println("Заметка '$title' успешно создана!")
    }

    private fun openNote(note: Note) {
        NoteScreen(note, menu).start()
    }
}
