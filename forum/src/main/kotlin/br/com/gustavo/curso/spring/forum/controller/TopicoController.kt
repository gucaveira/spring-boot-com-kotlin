package br.com.gustavo.curso.spring.forum.controller

import br.com.gustavo.curso.spring.forum.model.Curso
import br.com.gustavo.curso.spring.forum.model.Topico
import br.com.gustavo.curso.spring.forum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listar():List<Topico>{
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