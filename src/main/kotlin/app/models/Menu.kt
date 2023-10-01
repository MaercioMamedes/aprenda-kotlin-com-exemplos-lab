package app.models

import java.util.Scanner



object Menu {
    private val scannerMenu = Scanner(System.`in`)
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
            3 - MATRICULAR ALUNO
            4 - CRIAR FORMAÇÃO
            5 - LISTAR ALUNOS MATRICULADOS
            0 - SAIR DA APLICAÇÃO
            
            DIGITE O NÚMERO DA OPÇÃO DESEJADA: 
            
        """.trimIndent()
        print(options)
    }

    fun createStudent(){
        print("Digite o nome do Aluno: ")
        val name = scannerMenu.nextLine() // fazer validação de entrada

        val student:User = User(id=1, name=name)

        println(message = "Aluno $student matriculado com sucesso ")
    }

    fun listUsers(){
        // escrever método para listar alunos
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