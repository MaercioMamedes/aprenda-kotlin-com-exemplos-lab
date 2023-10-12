package app.models

import java.util.Scanner

var scannerMenu = Scanner(System.`in`)

object Menu {
    fun header(menu: String){
        // cabeçalho do menu

        infix fun Int.times(str: String) = str.repeat(this)
        val lineWidth = 100
        print("\n\n")
        println(lineWidth times "*")
        print(lineWidth/2 times " ")
        println(menu)
        println(lineWidth times "*")
    }

    fun options(){
        // opções de escolha do menu

        val options = """
            ESCOLHAS A OPÇÕES ABAIXO:
            
            1 - CRIAR ALUNO
            2 - LISTAR ALUNOS
            3 - LISTAR CURSOS
            4 - MATRICULAR ALUNO 
            5 - CRIAR FORMAÇÃO
            6 - LISTAR ALUNOS MATRICULADOS
            7 - LISTA FORMAÇÕES
            0 - SAIR DA APLICAÇÃO
            
            DIGITE O NÚMERO DA OPÇÃO DESEJADA:  
        """.trimIndent()
        print(options)
    }

    fun createUser(){
        // método para criar Aluno

        print("Digite o nome do Aluno: ")
        val name = scannerMenu.nextLine()

        val student:User = User.creteUser(name)

        println("Aluno $student cadastrado com sucesso ")

    }

    fun listUsers(){
        // método para listar todos alunos cadastrados

        header("LISTA DE ALUNOS CADASTRADOS")
        for ((count, user) in ListUsers.listUsers.withIndex()) {
            println("index: $count, $user")
        }
    }

    fun listEducationalContent(){
        // método para listar  todos os conteúdos cadastrados

        header("LISTA DE CONTEÚDOS CADASTRADOS")
        for ((count, content )in ListEducationalContent.listEducationalContent.withIndex()){
            println("index: $count - $content")

        }

    }

    fun listTraining(){
        // método para listar formações cadastradas

        header("LISTA FORMAÇÕES CADASTRADAS")
        for ((count, training) in ListTraining.listTraining.withIndex()){

            var totalTime = 0
            println("index: $count, Formação: ${training.name}")

            for (content in training.content){
                println(content)
                totalTime += content.time
                }

            println("\nTotal de matriculados: ${training.subscribes.size}")
            println("Tempo total da formação: $totalTime")
        }

    }

    fun createEnroll(){
        // criar método para gerar matrícula
        println("RELAÇÃO DE ALUNOS:\n")
        listUsers()
        println("RELAÇÃO DE FORMAÇÕES CADASTRADAS: ")
        listTraining()
        println("DIGITE O ÍNDICE DO ALUNO QUE DESEJA MATRICULAR")
        val indexUser = scannerMenu.nextLine()
        val user = ListUsers.listUsers[Integer.parseInt(indexUser)]
        println("DIGITE O ÍNDICE DA FORMAÇÃO QUE DESEJA MATRICULAR O ALUNO $user")
        val indexTraining = scannerMenu.nextLine()
        val training = ListTraining.listTraining[Integer.parseInt(indexTraining)]
        training.enroll(user)
    }

    fun createTraining(){
        // escrever método para criar formação
        listEducationalContent()
        println("DIGITE NO NOME DA FORMAÇÃO QUE VOCÊ ESTÁ CRIANDO")
        val trainingName = scannerMenu.nextLine()
        val listEducationalContent: MutableList<EducationalContent> = mutableListOf()

        do {

            println("DIGITE O ÍNDICE DO CURSO QUE VOCÊ DESEJA ADICIONAR")
            val indexEducationalContent = scannerMenu.nextLine()
            val educationalContent = ListEducationalContent.listEducationalContent[Integer.parseInt(indexEducationalContent)]
            listEducationalContent.add(educationalContent)
            println("Você escolheu o curso $educationalContent, deseja adicionar mais ?")
            val choice = scannerMenu.nextLine()

        } while (choice.equals("s", ignoreCase = true))

        Training.createTraining(trainingName, listEducationalContent)

    }

    fun listEnrolledUsers(){
        // escrever método para listar alunos matriculados

        println("DIGITE O ÍNDICE DA FORMAÇÃO: ")
        val indexTraining = scannerMenu.nextLine()
        header("LISTA DE ALUNOS MATRICULADOS")
        val training = ListTraining.listTraining[Integer.parseInt(indexTraining)]
        if (training.subscribes.size == 0) {
            println("NÃO EXISTE ALUNOS MATRICULADOS NESSA FORMAÇÃO")
        } else {
            for (user in training.subscribes) {
                println(user)
            }
        }
    }
}