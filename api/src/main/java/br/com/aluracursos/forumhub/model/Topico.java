package br.com.aluracursos.forumhub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Builder.Default
    private String estado = "ativo";

    private String autor;
    private String curso;
}