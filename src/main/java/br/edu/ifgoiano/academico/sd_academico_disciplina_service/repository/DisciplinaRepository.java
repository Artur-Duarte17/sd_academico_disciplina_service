package br.edu.ifgoiano.academico.sd_academico_disciplina_service.repository;

import br.edu.ifgoiano.academico.sd_academico_disciplina_service.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}