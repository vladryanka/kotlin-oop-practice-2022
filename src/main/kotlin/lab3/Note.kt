package lab3

import java.util.*


sealed class Note(
    open val title:String, open val data: Date
) {
    data class TextNote(override val title: String,override val data: Date, val text: String) : Note(title,data) {
        override fun toString(): String {
            return "TextNote(text='$text')"
        }
    }

    data class Task(
        override val title: String,override val data: Date,
        val description: String, val deadline: String
    ) : Note(title,data){
        override fun toString(): String {
            return "Task(description='$description')"
        }
    }

    data class Link(override val title: String,override val data: Date, val url: String) : Note(title,data) {
        override fun toString(): String {
            return "Link(url='$url')"
        }
    }

    override fun toString(): String {
        return "Note(title='$title', data=$data)"
    }

}