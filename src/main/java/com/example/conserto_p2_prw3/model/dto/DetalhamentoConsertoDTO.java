package com.example.conserto_p2_prw3.model.dto;

import com.example.conserto_p2_prw3.model.entities.Conserto;
import com.example.conserto_p2_prw3.model.entities.Mecanico;
import com.example.conserto_p2_prw3.model.entities.Veiculo;

public record DetalhamentoConsertoDTO(
        Long id,
        String dtEntrada,
        String dtSaida,
        Mecanico mecanico,
        Veiculo veiculo,
        Boolean ativo
) {
    public DetalhamentoConsertoDTO (Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDtEntrada(),
                conserto.getDtSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo(),
                conserto.getAtivo()
        );
    }
}
