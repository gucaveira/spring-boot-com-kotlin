package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Curso
import br.com.gustavo.curso.spring.forum.repositozry.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }
}