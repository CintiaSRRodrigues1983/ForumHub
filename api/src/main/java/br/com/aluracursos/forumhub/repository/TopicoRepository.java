package br.com.aluracursos.forumhub.repository;

import br.com.aluracursos.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.time.LocalDate;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
    List<Topico> findTop10ByOrderByDataCriacaoAsc();

    // Custom JPQL filter (busca tópicos por curso e ano)
    @Query("SELECT t FROM Topico t WHERE (:curso IS NULL OR t.curso = :curso) AND (:ano IS NULL OR FUNCTION('YEAR', t.dataCriacao) = :ano)")
    List<Topico> buscarPorCursoEAno(@Param("curso") String curso, @Param("ano") Integer ano);
}