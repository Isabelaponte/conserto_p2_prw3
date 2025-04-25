package com.example.conserto_p2_prw3.model.entities;

import com.example.conserto_p2_prw3.model.dto.MecanicoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private String anosExperiencia;

    public Mecanico(MecanicoDTO dados) {
        this.nome = dados.nome();
        this.anosExperiencia = dados.anosExperiencia();
    }

    public void atualizarDados(MecanicoDTO dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.anosExperiencia() != null)
            this.anosExperiencia = dados.anosExperiencia();
    }
}
