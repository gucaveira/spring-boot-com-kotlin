package br.com.gustavo.curso.spring.forum.controller

import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.TopicoView
import br.com.gustavo.curso.spring.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody topicoDto: NovoTopicoForm) {
        service.cadastrar(topicoDto)
    }
}