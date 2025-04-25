package com.example.conserto_p2_prw3.model.dto;

import com.example.conserto_p2_prw3.model.entities.Conserto;

public record ResumoConsertoDTO(
        String dtEntrada,
        String dtSaida,
        String nome,
        String marca,
        String modelo
) {

    public ResumoConsertoDTO(Conserto conserto) {
        this(
                conserto.getDtEntrada(),
                conserto.getDtSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }

}
