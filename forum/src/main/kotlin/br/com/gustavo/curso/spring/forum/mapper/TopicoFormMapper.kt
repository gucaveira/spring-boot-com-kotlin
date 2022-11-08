package br.com.gustavo.curso.spring.forum.mapper

import br.com.gustavo.curso.spring.forum.dto.NovoTopicoForm
import br.com.gustavo.curso.spring.forum.model.Topico
import br.com.gustavo.curso.spring.forum.service.CursoService
import br.com.gustavo.curso.spring.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}