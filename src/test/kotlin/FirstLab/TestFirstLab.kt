package FirstLab

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestFirstLab {

    @Test
    fun parser() {
        val string = "Pushkin//'I have loved you'//1830"
        assertEquals(
            listOf(Books("'I have loved you'", "Pushkin", 1830)),
            parser(string)
        )
    }

    @Test
    fun oldBook() {

        val string = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867"
        val list: List<Books> = parser(string)
        assertEquals(
            oldBook(list)[0], list[1]
        )
    }

    @Test
    fun youngBook() {
        val string = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867"
        val list: List<Books> = parser(string)
        assertEquals(
            youngBook(list)[0], list[0]
        )
    }

    @Test
    fun longName() {
        val string = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867"
        val list: List<Books> = parser(string)
        assertEquals(
            longName(list)[0], list[0]
        )
    }

    @Test
    fun shortName() {
        val string = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867"
        val list: List<Books> = parser(string)
        assertEquals(
            shortName(list)[0], list[1]
        )
    }
}