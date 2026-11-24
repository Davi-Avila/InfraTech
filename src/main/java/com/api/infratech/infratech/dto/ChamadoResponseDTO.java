package com.api.infratech.infratech.dto;

import java.time.LocalDate;

public record ChamadoResponseDTO(
        LocalDate diaAgendamento,
        String nome,
        String CEP,
        Integer numero,
        String descricao
) {
}
