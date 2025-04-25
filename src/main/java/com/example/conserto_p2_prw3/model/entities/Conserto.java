package com.example.conserto_p2_prw3.model.entities;

import com.example.conserto_p2_prw3.model.dto.DadosCadastroConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dtEntrada;
    private String dtSaida;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosCadastroConserto dados) {
        this.dtEntrada = dados.dtEntrada();
        this.dtSaida = dados.dtSaida();
        this.mecanico = dados.mecanico();
        this.veiculo = dados.veiculo();
    }
}
