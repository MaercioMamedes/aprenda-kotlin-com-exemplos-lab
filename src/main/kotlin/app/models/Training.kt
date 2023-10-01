package app.models

data class Training(val name: String, var content: List<EducationalContent>)
    val subscribes = mutableListOf<User>()

    fun enroll(user: User){
    // TODO("Utilize o parâmetro $user para simular uma matrícula (usar a lista de $inscritos).")
}