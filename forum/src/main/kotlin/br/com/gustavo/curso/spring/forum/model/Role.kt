package br.com.gustavo.curso.spring.forum.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import org.springframework.security.core.GrantedAuthority

@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val nome: String
) : GrantedAuthority {

    override fun getAuthority() = nome
}