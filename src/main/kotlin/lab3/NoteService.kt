package lab3

import java.util.*


class NoteService : NoteServiceInterface {
    private val notes: MutableList<Note> = mutableListOf()
    fun createText(title: String, data: Date, text: String): Note.TextNote {
        val texts = Note.TextNote(title, data, text)
        notes.add(texts)
        return texts
    }

    fun createTask(
        title: String, data: Date,
        description: String, deadline: String
    ): Note.Task {
        val task = Note.Task(title, data, description, deadline)
        notes.add(task)
        return task
    }

    fun createLink(title: String, data: Date, url: String): Note.Link {
        val link = Note.Link(title, data, url)
        notes.add(link)
        return link
    }

    override fun getAllNotes(): List<Note> = notes.toList()
    override fun getAllTextNotes(): List<Note.TextNote> = notes.filterIsInstance<Note.TextNote>()
    override fun getAllTasks(): List<Note.Task> = notes.filterIsInstance<Note.Task>()
    override fun getAllLinks(): List<Note.Link> = notes.filterIsInstance<Note.Link>()

    fun nameSorting() = notes.sortByDescending { it.title }
    fun dateSorting() = notes.sortByDescending { it.data }
    fun deleteNote(): Note = notes.removeAt(notes.size - 1)
    fun findNameNote(name: String) = notes.find { it.title == name }
    fun findTypeNote(type: Class<Any>): List<Note> = notes.filter { it.javaClass == type }
    override fun toString(): String {
        return "NoteService(notes=$notes)"
    }


}

