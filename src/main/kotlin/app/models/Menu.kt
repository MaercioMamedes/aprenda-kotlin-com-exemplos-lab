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

    fun createStudent(){
        print("Digite o nome do Aluno: ")
        val name = scannerMenu.nextLine() // fazer validação de entrada

        val student:User = User.creteUser(name)

        println("Aluno $student matriculado com sucesso ")

    }

    fun listUsers(){
        var count = 0
        for (user in ListUsers.listUsers!!) {
            println("index: $count, $user")
            count++
        }
    }

    fun listEducationalContent(){
        var count: Int = 0
        for (content in ListEducationalContent.listEducationalContent!!){
            println("index: $count - " + content)
            count++
        }

    }

    private fun println(s: String, content: EducationalContent) {

    }

    fun listTraining(){
        var count = 0
        for (training in ListTraining.listTraining){
            var totalTime: Int = 0

            println("index: $count, Formação: ${training.name}")

            for (content in training.content){
                println(content)
                totalTime += content.time
                }

            println("\nTotal de matriculados: ${training.subscribes.size}")
            println("Tempo total da formação: $totalTime")
            count++
        }

    }

    fun createEnroll(){
        // criar método para gerar matrícula
        println("RELAÇÃO DE ALUNOS:\n")
        listUsers()
        println("RELAÇÃO DE FORMAÇÕES CADASTRADAS: ")
        listTraining()
        println("DIGITE O ÍNDICE DO ALUNO QUE DESEJA MATRICULAR")
        val indexUser = scannerMenu.nextInt()
        val user = ListUsers.listUsers?.get(indexUser)
        println("DIGITE O ÍNDICE DA FORMAÇÃO QUE DESEJA MATRICULAR O ALUNO $user")
        val indexTraining = scannerMenu.nextInt()
        val training = ListTraining.listTraining[indexTraining]

        training.let {
            if (user != null) {
                it.enroll(user)

            }
        }


    }

    fun createTraining(){
        // escrever método para criar formação
        listEducationalContent()
        println("DIGITE NO NOME DA FORMAÇÃO QUE VOCÊ ESTÁ CRIANDO")
        val trainingName = scannerMenu.nextLine()
        var listEducationalContent: MutableList<EducationalContent> = mutableListOf()


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
        val indexTraining = scannerMenu.nextInt()
        val training = ListTraining.listTraining[indexTraining]
        if (training.subscribes.size == 0) {
            println("NÃO EXISTE ALUNOS MATRICULADOS NESSA FORMAÇÃO")
        } else {
            for (user in training.subscribes) {
                println(user)
            }
        }
    }
}