package br.edu.ifgoiano.academico.sd_academico_disciplina_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Dados para criação de uma disciplina")
public class DisciplinaRequestDTO {

    @Schema(description = "Nome da disciplina", example = "Banco de Dados")
    private String nome;

    @Schema(description = "Código único da disciplina", example = "BD01")
    private String codigo;

    @Schema(description = "Carga horária em horas", example = "80")
    private int cargaHoraria;
}
