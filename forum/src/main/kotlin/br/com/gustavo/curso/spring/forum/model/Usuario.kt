package br.com.gustavo.curso.spring.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val password: String,

    @JsonIgnore // com essa anotacao um get de lista de usuario vai ignorar a lista role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_role")
    val role: List<Role> = mutableListOf()
)
