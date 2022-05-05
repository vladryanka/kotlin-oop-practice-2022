@file:Suppress("NAME_SHADOWING")

package FirstLab


fun main() {

    val string = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867"
    val list: List<Books> = parser(string)
    println(longName(list))
    println(list[0])
   /* val bookString = "Pushkin//'I have loved you'//1830|Tolstoy//'War and Peace'//1867|Mayakovskiy//'Lilichka'//1934"
    val list: List<Books> = parser(bookString)
    println("The oldest Book: ")
    println(oldBook(list))
    println("The youngest Book: ")
    println(youngBook(list))
    println("The longest Book: ")
    println(longName(list))
    println("The shortest Book: ")
    println(shortName(list))*/
}