package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.model.Usuario
import br.com.gustavo.curso.spring.forum.repositozry.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
        //return repository.getReferenceById(id)
    }

}