package lab3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*


@Suppress("DEPRECATION")
internal class NoteServiceTest {

    private val text = Note.TextNote("my diary", Date(2021, 9, 24), "It was rainy day")
    private val link = Note.Link("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
    private val task = Note.Task("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
    @Test
    fun createText() {
        val noteService = NoteService()
        noteService.createText("my diary", Date(2021, 9, 24), "It was rainy day")
        assertEquals(listOf(text)[0], noteService.getAllTextNotes()[0])
    }

    @Test
    fun createTask() {
        val noteService = NoteService()
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        assertEquals(listOf(task)[0], noteService.getAllNotes()[0])
    }

    @Test
    fun createLink() {
        val noteService = NoteService()
        noteService.createLink("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
        assertEquals(listOf(link)[0], noteService.getAllNotes()[0])
    }

    @Test
    fun getAllNotes() {
        val noteService = NoteService()
        noteService.createLink("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        noteService.createText("my diary", Date(2021, 9, 24), "It was rainy day")
        assertEquals(listOf(link, task, text),noteService.getAllNotes())
    }

    @Test
    fun getAllTextNotes() {
        val noteService = NoteService()
        noteService.createText("my diary", Date(2021, 9, 24), "It was rainy day")
        noteService.createText("Birthday",Date(2022, 6, 20), "Vlada")
        val text2 = Note.TextNote("Birthday",Date(2022, 6, 20), "Vlada")
        assertEquals(listOf( text, text2),noteService.getAllTextNotes())
    }

    @Test
    fun getAllTasks() {
        val noteService = NoteService()
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        noteService.createTask("Plan", Date(2023, 4, 20), "Wake up, shower", "2023.4.21")
        val task2 = Note.Task("Plan", Date(2023, 4, 20), "Wake up, shower", "2023.4.21")
        assertEquals(listOf( task, task2),noteService.getAllTasks())
    }

    @Test
    fun getAllLinks() {
        val noteService = NoteService()
        noteService.createLink("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
        noteService.createLink("Inst", Date(2023, 2, 6), "https://instagram.com")
        val link2 =Note.Link("Inst", Date(2023, 2, 6), "https://instagram.com")
            assertEquals(listOf( link,link2),noteService.getAllLinks())
    }

    @Test
    fun nameSorting() {
        val noteService = NoteService()
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        noteService.createTask("Plan", Date(2023, 4, 20), "Wake up, shower", "2023.4.21")
        val task2 = Note.Task("Plan", Date(2023, 4, 20), "Wake up, shower", "2023.4.21")
        assertEquals(listOf(task, task2),noteService.nameSorting())
    }

    @Test
    fun dateSorting() {
        val noteService = NoteService()
        noteService.createLink("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        noteService.createText("my diary", Date(2021, 9, 24), "It was rainy day")
        noteService.dateSorting()
        assertEquals(listOf(task,link,text),noteService.getAllNotes())
    }

    @Test
    fun deleteNote() {
        val noteService = NoteService()
        noteService.createLink("VK", Date(2022, 1, 5), "https://vk.com/vladryanka")
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        noteService.createText("my diary", Date(2021, 9, 24), "It was rainy day")
        noteService.deleteNote()
        assertEquals(listOf(link,task),noteService.getAllNotes())
    }

    @Test
    fun findNameNote() {
        val noteService = NoteService()
        noteService.createTask("Homework", Date(2022, 4, 20), "Biology, Chemistry, IT, PE", "2022.5.1")
        assertEquals(listOf(task)[0],noteService.findNameNote("Homework"))
    }

}