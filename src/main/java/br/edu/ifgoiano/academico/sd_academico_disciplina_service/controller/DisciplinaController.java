package br.edu.ifgoiano.academico.sd_academico_disciplina_service.controller;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    // Task SADPMED-40: POST /disciplinas
    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> criar(@RequestBody DisciplinaRequestDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    // Task SADPMED-41: GET /disciplinas
    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    // Task SADPMED-42: GET /disciplinas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
