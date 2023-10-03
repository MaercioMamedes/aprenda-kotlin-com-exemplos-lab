package app.models

import java.util.Scanner

var scannerMenu = Scanner(System.`in`)

object Menu {
    fun header(){
        infix fun Int.times(str: String) = str.repeat(this)
        val lineWidth = 100
        println(lineWidth times "*")
        print(lineWidth/2 times " ")
        println("DIGITAL SCHOOLS")
        println(lineWidth times "*")
    }

    fun options(){
        val options = """
            ESCOLHAS A OPÇÕES ABAIXO:
            
            1 - CRIAR ALUNO
            2 - LISTAR ALUNOS
            3 - Lista Cursos
            4 - MATRICULAR ALUNO 
            5 - CRIAR FORMAÇÃO
            6 - LISTAR ALUNOS MATRICULADOS
            0 - SAIR DA APLICAÇÃO
            
            DIGITE O NÚMERO DA OPÇÃO DESEJADA:  
        """.trimIndent()
        print(options)
    }

    fun createStudent(){
        print("Digite o nome do Aluno: ")
        val name = scannerMenu.nextLine() // fazer validação de entrada

        val student:User = User.creteUser(name)

        println("Aluno $student matriculado com sucesso ")

    }

    fun listUsers(){
        for (user in ListUsers.listUsers!!) {
            println(user)
        }
    }

    fun listEducationalContent(){
        for (content in ListEducationalContent.listEducationalContent!!){
            println(content)
        }

    }

    fun createEnroll(){
        // criar método para gerar matrícula
    }

    fun createTraining(){
        // escrever método para criar formação
    }

    fun listEnrolledUsers(){
        // escrever método para listar alunos matriculados
    }
}