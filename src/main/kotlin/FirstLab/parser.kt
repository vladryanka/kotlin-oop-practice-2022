package FirstLab

fun parser(book: String): List<Books> {
    var bookCounter = 1// counter
    val n = book.length - 1 // size of string
    val bookList: MutableList<Books> = mutableListOf() // mutable List for string -> list
    for (i in 0..n) if (book[i] == '|') {
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
        while (year.length != 4) // year
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
fun oldBook(list: List<Books>): List<Books> {
    var maxVal = Int.MIN_VALUE
    for (bookNew in list) {

        if (bookNew.year > maxVal) {
            maxVal = bookNew.year
        }
    }
    return list.filter {it.year == maxVal}
}

fun youngBook(list: List<Books>): List<Books> {
    var minVal = Int.MAX_VALUE

    for (bookNew in list) {
        if (bookNew.year < minVal) {
            minVal = bookNew.year
        }
    }
    return list.filter {it.year == minVal}
}

fun longName(list: List<Books>): List<Books> {
    var length = 0
    var name = ""
    for (bookNew in list) {
        if (bookNew.name.length > length) {
            length = bookNew.name.length
            name = bookNew.name
        }
    }
    return list.filter {it.name == name}
}

fun shortName(list: List<Books>): List<Books> {
    var length = Int.MAX_VALUE
    var name = ""
    for (bookNew in list) {
        if (bookNew.name.length < length) {
            length = bookNew.name.length
            name = bookNew.name
        }
    }
    return list.filter {it.name == name}
}