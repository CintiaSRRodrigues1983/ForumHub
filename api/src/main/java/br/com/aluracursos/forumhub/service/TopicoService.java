package br.com.aluracursos.forumhub.service;

import br.com.aluracursos.forumhub.dto.RequisicaoDTO;
import br.com.aluracursos.forumhub.dto.RespostaDTO;
import br.com.aluracursos.forumhub.model.Topico;
import br.com.aluracursos.forumhub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class TopicoService {
    private final TopicoRepository repositorio;

    public RespostaDTO cadastrar(RequisicaoDTO dto) {
        if (repositorio.existsByTituloAndMensagem(dto.getTitulo(), dto.getMensagem())) {
            throw new IllegalArgumentException("Tópico duplicado: título e mensagem já existem.");
        }
        Topico topico = Topico.builder()
                .titulo(dto.getTitulo())
                .mensagem(dto.getMensagem())
                .autor(dto.getAutor())
                .curso(dto.getCurso())
                .build();
        Topico salvo = repositorio.save(topico);
        return RespostaDTO.builder()
                .id(salvo.getId())
                .titulo(salvo.getTitulo())
                .mensagem(salvo.getMensagem())
                .estado(salvo.getEstado())
                .autor(salvo.getAutor())
                .curso(salvo.getCurso())
                .dataCriacao(salvo.getDataCriacao())
                .build();
    }

    public List<RespostaDTO> listar() {
        return repositorio.findAll().stream().map(RespostaDTO::new).toList();
    }

    public List<RespostaDTO> listarPrimeiros10() {
        return repositorio.findTop10ByOrderByDataCriacaoAsc()
                .stream().map(RespostaDTO::new).toList();
    }

    public Page<RespostaDTO> listarPaginado(Pageable pageable) {
        return repositorio.findAll(pageable).map(RespostaDTO::new);
    }

    public List<RespostaDTO> listarFiltrado(String curso, Integer ano) {
        List<Topico> topicos = repositorio.buscarPorCursoEAno(curso, ano);
        return topicos.stream().map(RespostaDTO::new).toList();
    }

        // No método service
    public RespostaDTO detalhar(Long id) {
        Topico topico = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));
        return new RespostaDTO(topico);
    }

    public RespostaDTO atualizar(Long id, RequisicaoDTO dto) {
        Topico topico = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));

        // Checagem para duplicidade (outro tópico já tem o mesmo título e mensagem)
        boolean duplicado = repositorio.existsByTituloAndMensagem(dto.getTitulo(), dto.getMensagem());
        if (duplicado && !(topico.getTitulo().equals(dto.getTitulo()) && topico.getMensagem().equals(dto.getMensagem()))) {
            throw new IllegalArgumentException("Tópico duplicado: título e mensagem já existem.");
        }

        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        Topico salvo = repositorio.save(topico);
        return new RespostaDTO(salvo);
    }

    public void excluir(Long id) {
        var topico = repositorio.findById(id);
        if (topico.isPresent()) {
            repositorio.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado");
        }
    }

}