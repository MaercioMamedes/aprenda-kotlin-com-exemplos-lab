package app

import app.models.Menu
import java.util.Scanner


// Arquivo principal da aplicação, responsável pela renderização do menu e chamada das funções

val menu = Menu
var scanner = Scanner(System.`in`)
var choice: Int? = null

fun main() {
    createEducationalContent()
    createUsers()
    createTraining()
    loopMenu()
}

fun loopMenu(){
    menu.header("DIGITAL SCHOOLS")

    do {
        menu.options()
        choice = scanner.nextInt()


        when (choice) {
            1 -> {
                menu.createUser()
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

            7 -> {
                menu.listTraining()
                loopMenu()
            }

        }

    }while (choice != 0)
}

