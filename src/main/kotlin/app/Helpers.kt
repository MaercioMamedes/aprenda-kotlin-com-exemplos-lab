package app

import app.models.*
import kotlin.random.Random

fun createEducationalContent(){

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

fun createTraining(): Training {
    var content: MutableList<EducationalContent> = mutableListOf()
    for (educationalContent in ListEducationalContent.listEducationalContent!!){
        if (educationalContent.name == "Python" || educationalContent.name == "PHP" || educationalContent.name == "NODE"){
            content.add(educationalContent)
        }
    }

    val training = Training(name = "Backend", content=content)
    ListTraining.listTraining.add(training)
    return training
}
