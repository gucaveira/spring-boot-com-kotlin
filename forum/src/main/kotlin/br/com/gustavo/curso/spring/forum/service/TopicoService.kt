package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Curso
import br.com.gustavo.curso.spring.forum.model.Topico
import br.com.gustavo.curso.spring.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "Variaveis no kotlin",
            curso = Curso(id = 1, nome = "Kotlin basico", "programação"),
            autor = Usuario(1, "Gustavo", "gustavo@gmail.com")
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida kotlin 2",
            mensagem = "Variaveis no kotlin 2",
            curso = Curso(id = 1, nome = "Kotlin basico", "programação"),
            autor = Usuario(1, "Gustavo", "gustavo@gmail.com")
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvida kotlin 3",
            mensagem = "Variaveis no kotlin 3",
            curso = Curso(id = 1, nome = "Kotlin basico", "programação"),
            autor = Usuario(1, "Gustavo", "gustavo@gmail.com")
        )

        topicos = listOf(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {

      /*  topicos.find {
            it.id == id
        }*/

        return topicos.stream().filter {
            it.id == id
        }.findFirst().get()
    }
}