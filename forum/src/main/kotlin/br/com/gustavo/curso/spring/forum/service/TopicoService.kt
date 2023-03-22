package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.dto.AtualizacaoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.TopicoPorCategoriaDto
import br.com.gustavo.curso.spring.forum.dto.TopicoView
import br.com.gustavo.curso.spring.forum.exception.NotFoundException
import br.com.gustavo.curso.spring.forum.mapper.TopicoFormMapper
import br.com.gustavo.curso.spring.forum.mapper.TopicoViewMapper
import br.com.gustavo.curso.spring.forum.repositozry.TopicoRepository
import java.util.stream.Collectors
import javax.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!",
    private val entityManager: EntityManager
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        println(entityManager)
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
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

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }
}