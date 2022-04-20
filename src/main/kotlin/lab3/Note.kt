package lab3

import java.util.*


sealed class Note(var title:String,
                  var data: Date
) {
    class TextNote( title:String, data:Date,val text:String):Note (title,data){
        override fun toString(): String {
            return "TextNote(text='$text')"
        }
    }
    class Task(
        title: String, data: Date,
        val description: String, deadline: String
    ): Note(title,data) {
        override fun toString(): String {
            return "Task(description='$description')"
        }
    }
    class Link(title:String, data: Date, val url:String):Note(title,data) {
        override fun toString(): String {
            return "Link(url='$url')"
        }
    }

    override fun toString(): String {
        return "Note(title='$title', data=$data)"
    }
}