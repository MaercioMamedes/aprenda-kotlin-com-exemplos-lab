package app.models

data class EducationalContent(val name: String, val time: Int, val level: Level){

    companion object{
        fun createEducationalContent(name: String, time: Int, level: Level): EducationalContent {
            val content = EducationalContent(name, time, level)
            ListEducationalContent.listEducationalContent.add(content)

            return content
        }
    }

    override fun toString(): String {
        return "Content: name='$name', time=$time, level=$level"
    }
}
