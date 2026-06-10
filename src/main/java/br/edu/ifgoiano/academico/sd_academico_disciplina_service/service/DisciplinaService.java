package br.edu.ifgoiano.academico.sd_academico_disciplina_service.service;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.model.Disciplina;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaRequestDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto.DisciplinaResponseDTO;
import br.edu.ifgoiano.academico.sd_academico_disciplina_service.repository.DisciplinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    private static final Logger logger = LoggerFactory.getLogger(DisciplinaService.class);

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public DisciplinaResponseDTO salvar(DisciplinaRequestDTO dto) {
        logger.info("[DISCIPLINA-SERVICE] Criando disciplina: {} ({})", dto.getNome(), dto.getCodigo());

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setCodigo(dto.getCodigo());
        disciplina.setCargaHoraria(dto.getCargaHoraria());

        Disciplina salva = repository.save(disciplina);
        logger.info("[DISCIPLINA-SERVICE] Disciplina criada com sucesso - ID: {}, Código: {}", salva.getId(), salva.getCodigo());
        return converteParaDTO(salva);
    }

    public List<DisciplinaResponseDTO> listarTodas() {
        logger.info("[DISCIPLINA-SERVICE] Listando todas as disciplinas");
        return repository.findAll().stream()
                .map(this::converteParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaResponseDTO> buscarPorId(Long id) {
        logger.info("[DISCIPLINA-SERVICE] Buscando disciplina ID: {}", id);
        Optional<DisciplinaResponseDTO> resultado = repository.findById(id).map(this::converteParaDTO);
        if (resultado.isEmpty()) {
            logger.warn("[DISCIPLINA-SERVICE] Disciplina ID {} não encontrada", id);
        }
        return resultado;
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