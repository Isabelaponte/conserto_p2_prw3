package com.example.conserto_p2_prw3.controller;

import com.example.conserto_p2_prw3.model.dto.DadosCadastroConserto;
import com.example.conserto_p2_prw3.model.entities.Conserto;
import com.example.conserto_p2_prw3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConserto dados){
        repository.save(new Conserto(dados));
    }
}
