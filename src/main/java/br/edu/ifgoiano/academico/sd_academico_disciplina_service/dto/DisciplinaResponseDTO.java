package br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class DisciplinaResponseDTO {
    private Long id;
    private String nome;
    private String codigo;
    private int cargaHoraria;
}