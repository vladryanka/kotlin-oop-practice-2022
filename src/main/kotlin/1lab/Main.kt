@file:Suppress("NAME_SHADOWING")

package `1lab`


fun parser(book: String): List<Books> {
    if (book.isEmpty())
        throw IllegalArgumentException("Book string is empty")
    else {

        var bookCounter = 1// counter
        val n = book.length - 1 // size of string
        val bookList: MutableList<Books> = mutableListOf() // mutable List for string -> list
        for (i in 0..n)
            if (book[i] == '|') {
                bookCounter++
            }
        var year = ""
        var bookCounterNew = 0
        var name = ""
        var i = 0
        var authorBook = ""
        for (j in 0 until bookCounter) {
                while (book[i] != '/') // Authors
                {
                    authorBook += book[i]
                    i++
                }
                i += 2
                while (book[i] != '/') // Name
                {
                    name += book[i]
                    i++
                }
                i += 2
                while (year.length!=4) // year
                {
                    year += book[i]
                    i++
                }
                val booknew = Books(name, authorBook, year.toInt())
                bookList.add(booknew)
                year = ""
                authorBook = ""
                name = ""
                bookCounterNew++
                i++
        }
        return bookList
    }


}

fun OldBook(list: List<Books>): Int {
    var maxval = Int.MIN_VALUE
    if (list.isEmpty())
        throw IllegalArgumentException("Book string is empty")
    else {

        for (booknew in list) {
            if (booknew.year > maxval) {
                maxval = booknew.year
            }
        }
    }
    return maxval
}

fun YoungBook(list: List<Books>): Int {
    var minval = Int.MAX_VALUE
    if (list.isEmpty())
        throw IllegalArgumentException("Book string is empty")
    else {
        for (booknew in list) {
            if (booknew.year < minval) {
                minval = booknew.year
            }
        }
    }
    return minval
}

fun LongName(list: List<Books>): String {
    var length = 0
    var name = ""
    for (booknew in list) {
        if (booknew.Name.length > length) {
            length = booknew.Name.length
            name = booknew.Name
        }
    }
    return name
}

fun ShortName(list: List<Books>): String {
    var length = Int.MAX_VALUE
    var name = ""
    for (booknew in list) {
        if (booknew.Name.length < length) {
            length = booknew.Name.length
            name = booknew.Name
        }
    }
    return name
}

fun main() {

    val bookString = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867|Mayakovskiy//'Lilichka'//1934"
    val list: List<Books> = parser(bookString)
    println("The oldest Book: ")
    println(OldBook(list))
    println("The youngest Book: ")
    println(YoungBook(list))
    println("The longest Book: ")
    println(LongName(list))
    println("The shortest Book: ")
    println(ShortName(list))
}