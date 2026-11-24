package com.api.infratech.infratech.dto;

import jakarta.validation.constraints.NotBlank;

public record DefeitoDTO(
        @NotBlank(message = "Digite a descrição do defeito")
        String descricao,

        @NotBlank(message = "Digite o nome do condominio")
        String nome
) {
}
