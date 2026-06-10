package br.edu.ifgoiano.academico.sd_academico_disciplina_service.controller;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@Tag(name = "Disciplinas", description = "Cadastro e consulta de disciplinas")
public class DisciplinaController {

    private static final Logger logger = LoggerFactory.getLogger(DisciplinaController.class);

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Criar disciplina", description = "Cadastra uma nova disciplina.")
    public ResponseEntity<DisciplinaResponseDTO> criar(@RequestBody DisciplinaRequestDTO dto) {
        logger.info("[DISCIPLINA-SERVICE] POST /disciplinas - código: {}", dto.getCodigo());
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar disciplinas", description = "Retorna todas as disciplinas cadastradas.")
    public ResponseEntity<List<DisciplinaResponseDTO>> listar() {
        logger.info("[DISCIPLINA-SERVICE] GET /disciplinas");
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar disciplina por ID", description = "Retorna a disciplina com o ID informado, ou 404 se não existir.")
    public ResponseEntity<DisciplinaResponseDTO> buscarPorId(
            @Parameter(description = "ID da disciplina", example = "1") @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
