package com.example.conserto_p2_prw3.model.dto;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,

        String anosExperiencia
) {}
