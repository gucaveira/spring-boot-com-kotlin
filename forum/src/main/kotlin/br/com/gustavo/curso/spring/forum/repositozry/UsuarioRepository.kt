package br.com.gustavo.curso.spring.forum.repositozry

import br.com.gustavo.curso.spring.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    fun findByEmail(username: String?): Usuario?
}