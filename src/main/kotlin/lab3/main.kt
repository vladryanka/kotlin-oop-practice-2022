@file:Suppress("DEPRECATION")

package lab3


import java.util.*

fun main(){
    val noteService = NoteService()
    noteService.createLink("VK",Date(2022, 1, 5) ,"https://vk.com/vladryanka"  )
    noteService.createTask("Homework", Date(2022, 4 ,20), "Biology, Chemistry, IT, PE", "2022.5.1")
    noteService.createText("my diary", Date(2021,9,24), "It was rainy day")
    noteService.createText("mum's diary", Date(2021,12,13), "I'm tired because of my children")
    println("All Notes: ${noteService.getAllNotes()}")
    println("All Links: ${noteService.getAllLinks()}")
    println("All Tasks: ${noteService.getAllTasks()}")
    println("All TextNotes: ${noteService.getAllTextNotes()}")
    println("sort by date: ${noteService.dateSorting()}")
    println("sort by name: ${noteService.nameSorting()}")
    println("find by name: ${noteService.findNameNote("Homework")}")
    println("find by type: ${noteService.findTypeNote(noteService.javaClass)}")
    noteService.deleteNote()
    

}