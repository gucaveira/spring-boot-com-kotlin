package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Curso
import br.com.gustavo.curso.spring.forum.model.Topico
import br.com.gustavo.curso.spring.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {

    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "Variaveis no kotlin",
            curso = Curso(id = 1, nome = "Kotlin basico", "programação"),
            autor = Usuario(1, "Gustavo", "gustavo@gmail.com")
        )
        return listOf(topico, topico, topico)
    }
}