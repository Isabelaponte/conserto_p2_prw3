package com.example.conserto_p2_prw3.model.dto;

import com.example.conserto_p2_prw3.model.entities.Mecanico;
import com.example.conserto_p2_prw3.model.entities.Veiculo;

public record DadosCadastroConserto(String dtEntrada, String dtSaida, Mecanico mecanico, Veiculo veiculo) {
}
