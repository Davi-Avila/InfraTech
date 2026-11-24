package com.api.infratech.infratech.dto;

import com.api.infratech.infratech.model.Condominio;
import com.api.infratech.infratech.model.Defeito;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ChamadoRequestDTO(
        @NotNull(message = "Digite o dia do agendamento")
        LocalDate diaAgendamento,

        @NotBlank(message = "Digite o nome do condomínio")
        String nome,

        Long idDefeito
) {
}
