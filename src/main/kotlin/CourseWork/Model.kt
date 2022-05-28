package CourseWork
import java.util.*

interface NoteServiceInterface {
    fun getAllNotes(): List<lab3.Note>
    fun getAllTextNotes(): List<lab3.Note.TextNote>
    fun getAllTasks(): List<lab3.Note.Task>
    fun createText(title: String, data: Date, text: String): lab3.Note.TextNote
    fun createTask(
        title: String, data: Date,
        description: String, deadline: String
    ): lab3.Note.Task
    fun createLink(title: String, data: Date, url: String): lab3.Note.Link
    fun getAllLinks(): List<lab3.Note.Link>
    fun nameSorting()
    fun dateSorting()
    fun deleteNote(): lab3.Note
    fun findTypeNote(type: Class<Any>): List<lab3.Note>
}
sealed class Note(
    open val title:String, open val data: Date
) {
    data class TextNote(override val title: String, override val data: Date, val text: String) : Note(title,data) {
        override fun toString(): String {
            return "TextNote(text='$text')"
        }
    }

    data class Task(
        override val title: String, override val data: Date,
        val description: String, val deadline: String
    ) : Note(title,data){
        override fun toString(): String {
            return "Task(description='$description')"
        }
    }

    data class Link(override val title: String, override val data: Date, val url: String) : Note(title,data) {
        override fun toString(): String {
            return "Link(url='$url')"
        }
    }
    override fun toString(): String {
        return "Note(title='$title', data=$data)"
    }
}
enum class State
{
    Open, Closed
}
interface ModelChangeListener {
    fun onModelChanged()
}

class Model {
    private val notes: MutableList<lab3.Note> = mutableListOf()
    fun createText(title: String, data: Date, text: String): lab3.Note.TextNote {
        val texts = lab3.Note.TextNote(title, data, text)
        notes.add(texts)
        listeners.forEach { it.onModelChanged() }
        return texts
    }

    var state = State.Open
    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }
    fun createTask(
        title: String, data: Date,
        description: String, deadline: String
    ): lab3.Note.Task {
        val task = lab3.Note.Task(title, data, description, deadline)
        notes.add(task)
        listeners.forEach { it.onModelChanged() }
        return task
    }

    fun createLink(title: String, data: Date, url: String): lab3.Note.Link {
        val link = lab3.Note.Link(title, data, url)
        notes.add(link)
        listeners.forEach { it.onModelChanged() }
        return link
    }
    fun getAllNotes(): List<lab3.Note> = notes.toList()
    fun getAllTextNotes(): List<lab3.Note.TextNote> = notes.filterIsInstance<lab3.Note.TextNote>()
    fun getAllTasks(): List<lab3.Note.Task> = notes.filterIsInstance<lab3.Note.Task>()
    fun getAllLinks(): List<lab3.Note.Link> = notes.filterIsInstance<lab3.Note.Link>()

    fun nameSorting() = notes.sortByDescending { it.title }
    fun dateSorting() = notes.sortByDescending { it.data }
    fun deleteNote(): lab3.Note
    {
        listeners.forEach { it.onModelChanged() }
        return notes.removeAt(notes.size - 1)
    }
    fun findNameNote(name: String) = notes.find { it.title == name }
    fun findTypeNote(type: Class<Any>): List<lab3.Note> = notes.filter { it.javaClass == type }
}


