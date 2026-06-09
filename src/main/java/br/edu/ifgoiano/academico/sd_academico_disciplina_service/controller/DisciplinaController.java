package br.edu.ifgoiano.academico.sd_academico_disciplina_service.controller;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.service.DisciplinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private static final Logger logger = LoggerFactory.getLogger(DisciplinaController.class);

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> criar(@RequestBody DisciplinaRequestDTO dto) {
        logger.info("[DISCIPLINA-SERVICE] POST /disciplinas - código: {}", dto.getCodigo());
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listar() {
        logger.info("[DISCIPLINA-SERVICE] GET /disciplinas");
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarPorId(@PathVariable Long id) {
        logger.info("[DISCIPLINA-SERVICE] GET /disciplinas/{}", id);
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
