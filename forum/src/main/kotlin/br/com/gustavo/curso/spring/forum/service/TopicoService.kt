package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.dto.AtualizacaoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.TopicoView
import br.com.gustavo.curso.spring.forum.exception.NotFoundException
import br.com.gustavo.curso.spring.forum.mapper.TopicoFormMapper
import br.com.gustavo.curso.spring.forum.mapper.TopicoViewMapper
import br.com.gustavo.curso.spring.forum.repositozry.TopicoRepository
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso)
        }

        return topicos.map {
            topicoViewMapper.map(it)
        }
    }

    fun buscarPorId(id: Long): TopicoView {

        /*  topicos.find {
              it.id == id
          }*/

        val topico = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atulizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        val topico = repository.deleteById(id)
    }
}