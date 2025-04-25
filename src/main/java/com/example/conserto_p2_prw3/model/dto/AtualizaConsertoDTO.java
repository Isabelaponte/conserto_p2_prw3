package com.example.conserto_p2_prw3.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizaConsertoDTO(
        @NotNull
        Long id,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dtSaida,
        DadosMecanico mecanico
) { }
