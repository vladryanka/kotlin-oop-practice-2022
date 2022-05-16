package lab3
import java.util.*
interface NoteServiceInterface {
    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun createText(title: String, data: Date, text: String): Note.TextNote
    fun createTask(
        title: String, data: Date,
        description: String, deadline: String
    ): Note.Task
    fun createLink(title: String, data: Date, url: String): Note.Link
    fun getAllLinks(): List<Note.Link>
    fun nameSorting()
    fun dateSorting()
    fun deleteNote(): Note
    fun findTypeNote(type: Class<Any>): List<Note>
}