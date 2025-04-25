package com.example.conserto_p2_prw3.model.dto;

import com.example.conserto_p2_prw3.model.entities.Mecanico;
import com.example.conserto_p2_prw3.model.entities.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dtEntrada,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String dtSaida,

        @Valid
        Mecanico mecanico,

        @Valid
        Veiculo veiculo
) { }
