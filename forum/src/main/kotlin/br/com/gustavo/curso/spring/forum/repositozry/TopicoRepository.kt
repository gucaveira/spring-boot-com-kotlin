package br.com.gustavo.curso.spring.forum.repositozry

import br.com.gustavo.curso.spring.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
}