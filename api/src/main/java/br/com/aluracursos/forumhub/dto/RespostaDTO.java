package br.com.aluracursos.forumhub.dto;

import br.com.aluracursos.forumhub.model.Topico;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespostaDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private String estado;
    private String autor;
    private String curso;
    private LocalDateTime dataCriacao;

    public RespostaDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.estado = topico.getEstado();
        this.autor = topico.getAutor();
        this.curso = topico.getCurso();
        this.dataCriacao = topico.getDataCriacao();
    }
}