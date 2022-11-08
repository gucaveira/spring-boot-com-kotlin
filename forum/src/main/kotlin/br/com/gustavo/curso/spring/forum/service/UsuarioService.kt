package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(private var usuarios: MutableList<Usuario>) {

    init {
        val usuario = Usuario(id = 1, nome = "Gustavo Pereira", "gustavo@gmail.com")

        usuarios.add(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { it.id == id }.findFirst().get()
    }

}