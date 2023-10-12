package app.models

data class Training(val name: String, var content: MutableList<EducationalContent>){
    val subscribes = mutableListOf<User>()

    fun enroll(user: User){
    // TODO("Utilize o parâmetro $user para simular uma matrícula (usar a lista de $inscritos).")
        this.subscribes.add(user)
}

    companion object{
        fun createTraining(name: String,listEducationalContent: MutableList<EducationalContent>): Training{
            val training = Training(name, listEducationalContent)
            ListTraining.listTraining.add(training)
            return training
        }
    }

}