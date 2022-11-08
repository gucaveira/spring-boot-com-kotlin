package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.dto.AtualizacaoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.TopicoView
import br.com.gustavo.curso.spring.forum.mapper.TopicoFormMapper
import br.com.gustavo.curso.spring.forum.mapper.TopicoViewMapper
import br.com.gustavo.curso.spring.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.map {
            topicoViewMapper.map(it)
        }
    }

    fun buscarPorId(id: Long): TopicoView {

        /*  topicos.find {
              it.id == id
          }*/

        val topico = topicos.stream().filter {
            it.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atulizar(form: AtualizacaoTopicoForm) {
        val topico = topicos.stream().filter {
            it.id == form.id
        }.findFirst().get()

        topicos = topicos.minus(topico).plus(
            Topico(
                id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                autor = topico.autor,
                curso = topico.curso,
                respostas = topico.respostas,
                status = topico.status,
                dataCriacao = topico.dataCriacao,
            )
        )
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter {
            it.id == id
        }.findFirst().get()

        topicos = topicos.minus(topico)
    }
}