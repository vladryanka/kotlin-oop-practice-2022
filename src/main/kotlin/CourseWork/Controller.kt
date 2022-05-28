package CourseWork

class Controller(private val model: Model) {
    init {
        startNote()
    }
    private fun startNote() {
        while (model.state == State.Open) {
            val input = readln()
            try {
                val col = input.substringBefore(" ").toInt() - 1
                val row = input.substringAfter(" ").toInt() - 1

              //  model.createTask()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}