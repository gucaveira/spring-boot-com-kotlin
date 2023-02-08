package br.com.gustavo.curso.spring.forum.repositozry

import br.com.gustavo.curso.spring.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {

    // Esse padrão de escrita de funão permite que seja criado
    // uma queue de SQL, usando as palavras da função
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
}