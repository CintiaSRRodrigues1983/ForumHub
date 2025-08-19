package br.com.aluracursos.forumhub.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequisicaoDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @NotBlank
    private String autor;
    @NotBlank
    private String curso;
}