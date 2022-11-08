package br.com.gustavo.curso.spring.forum.service

import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.dto.TopicoView
import br.com.gustavo.curso.spring.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<TopicoView> {
        return topicos.map {
            TopicoView(
                id = it.id,
                titulo = it.titulo,
                mensagem = it.mensagem,
                status = it.status,
                dataCriacao = it.dataCriacao
            )
        }
    }

    fun buscarPorId(id: Long): TopicoView {

        /*  topicos.find {
              it.id == id
          }*/

        val topico = topicos.stream().filter {
            it.id == id
        }.findFirst().get()

        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(topicoDto: NovoTopicoForm) {
        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = topicoDto.titulo,
                mensagem = topicoDto.mensagem,
                curso = cursoService.buscarPorId(topicoDto.idCurso),
                autor = usuarioService.buscarPorId(topicoDto.idAutor)
            )
        )
    }
}