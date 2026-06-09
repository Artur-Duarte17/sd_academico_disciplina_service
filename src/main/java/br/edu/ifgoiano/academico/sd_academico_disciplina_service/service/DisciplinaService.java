package br.edu.ifgoiano.academico.sd_academico_disciplina_service.service;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.model.Disciplina;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    // Salvar (POST)
    public DisciplinaResponseDTO salvar(DisciplinaRequestDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setCodigo(dto.getCodigo());
        disciplina.setCargaHoraria(dto.getCargaHoraria());

        Disciplina salva = repository.save(disciplina);
        return converteParaDTO(salva);
    }

    // Listar Todas (GET)
    public List<DisciplinaResponseDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::converteParaDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID (GET /{id})
    public Optional<DisciplinaResponseDTO> buscarPorId(Long id) {
        return repository.findById(id).map(this::converteParaDTO);
    }

    private DisciplinaResponseDTO converteParaDTO(Disciplina disciplina) {
        DisciplinaResponseDTO response = new DisciplinaResponseDTO();
        response.setId(disciplina.getId());
        response.setNome(disciplina.getNome());
        response.setCodigo(disciplina.getCodigo());
        response.setCargaHoraria(disciplina.getCargaHoraria());
        return response;
    }
}