package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(private var cursos: MutableList<Curso>) {

    init {
        val curso = Curso(id = 1, nome = "Kotlin basico", "programação")

        cursos.add(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { it.id == id }.findFirst().get()
    }
}