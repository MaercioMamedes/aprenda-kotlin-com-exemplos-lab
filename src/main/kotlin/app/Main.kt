package app

import app.models.Menu
import java.util.Scanner

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

val menu = Menu
var scanner = Scanner(System.`in`)
var choice: Int? = null

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    createTraining()
    createUsers()
    loopMenu()

}

fun loopMenu(){
    menu.header()

    do {
        menu.options()
        choice = scanner.nextInt() // fazer validação de entrada


        when (choice) {
            1 -> {
                menu.createStudent()
                loopMenu()
            }

            2 -> {
                menu.listUsers()
                loopMenu()
            }

            3 -> {
                menu.listEducationalContent()
                loopMenu()
            }

            4 -> {
                menu.createEnroll()
                loopMenu()
            }

            5 -> {
                menu.createTraining()
                loopMenu()
            }

            6 -> {
                menu.listEnrolledUsers()
                loopMenu()
            }

        }

    }while (choice != 0)
}

