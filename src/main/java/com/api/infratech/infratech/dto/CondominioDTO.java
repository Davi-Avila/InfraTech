package com.api.infratech.infratech.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CondominioDTO(
        @NotBlank(message = "Digite o nome do condominio")
        String nome,

        @NotBlank(message = "Digite o CEP condominio")
        String CEP,

        @NotNull(message = "Digite o número da sua residência")
        @Min(0)
        Integer numero
) {
}
