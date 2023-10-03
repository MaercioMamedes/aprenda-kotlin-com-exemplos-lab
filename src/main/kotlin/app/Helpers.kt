package app

import app.models.EducationalContent
import app.models.Level
import app.models.User
import kotlin.random.Random

fun createTraining(){

    val listCourseName = listOf("Python", "Javascript", "PHP", "HTML5", "CSS3", "REACT.JS", "VUE.JS", "NODE")
    val listCourseTime = listOf(10, 40, 60, 80 )
    val listCourseLevel = listOf(Level.EASY, Level.MEDIUM, Level.HARD)

    for (i in 0..listCourseName.size){
        val courseName = listCourseName[Random.nextInt(listCourseName.size)]
        val courseTime = listCourseTime[Random.nextInt(listCourseTime.size)]
        val courseLevel = listCourseLevel[Random.nextInt(listCourseLevel.size)]

        EducationalContent.createEducationalContent(courseName, courseTime, courseLevel)

    }

}

fun createUsers(){
    val listNameUsers = listOf("Pedro", "João", "Thiago", "Matheus", "André", "Filipe")

    for (name in listNameUsers){
        User.creteUser(name)
    }
}