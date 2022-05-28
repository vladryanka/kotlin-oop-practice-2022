package CourseWork

class ConsoleUI(private val model: Model) {
    init {
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        model.addModelChangeListener(listener)
        repaint()
    }

    private fun repaint() {
        Runtime.getRuntime().exec("clear")
        println(model)
    }
}