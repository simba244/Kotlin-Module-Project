package menu

import model.Archive
import util.InputUtils

class ArchiveMenu(
    private val menu: Menu = Menu(),
) {
    private val archives = mutableListOf<Archive>()

    fun start() {
        menu.show("Список архивов:") { exit ->
            val list = mutableListOf<MenuItem>()
            list.add(MenuItem("Создать архив") { createArchive() })
            archives.forEach { archive ->
                list.add(MenuItem(archive.name) { openArchive(archive) })
            }
            list.add(MenuItem("Выход") { exit() })
            list
        }
    }

    private fun createArchive() {
        println("\n--- Создание архива ---")
        val name = InputUtils.readNonEmptyString(
            prompt = "Введите имя архива: ",
            errorMessage = "Имя архива не может быть пустым."
        )
        archives.add(Archive(name))
        println("Архив '$name' успешно создан!")
    }

    private fun openArchive(archive: Archive) {
        NoteMenu(archive, menu).start()
    }
}
