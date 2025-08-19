package br.com.aluracursos.forumhub.controller;

import br.com.aluracursos.forumhub.dto.RequisicaoDTO;
import br.com.aluracursos.forumhub.dto.RespostaDTO;
import br.com.aluracursos.forumhub.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor

public class TopicoController {
    private final TopicoService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody RequisicaoDTO dto) {
        try {
            RespostaDTO resposta = service.cadastrar(dto);
            return ResponseEntity.ok(resposta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<RespostaDTO>> listar() {
        List<RespostaDTO> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/primeiros")
    public ResponseEntity<List<RespostaDTO>> listarPrimeiros() {
        return ResponseEntity.ok(service.listarPrimeiros10());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<RespostaDTO>> listarPaginado(
            @PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.listarPaginado(pageable));
    }

    @GetMapping("/filtrado")
    public ResponseEntity<List<RespostaDTO>> listarFiltrado(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer ano) {
        List<RespostaDTO> lista = service.listarFiltrado(curso, ano);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        try {
            RespostaDTO resposta = service.detalhar(id);
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody RequisicaoDTO dto) {
        try {
            RespostaDTO resposta = service.atualizar(id, dto);
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não encontrado");
        }
    }
}