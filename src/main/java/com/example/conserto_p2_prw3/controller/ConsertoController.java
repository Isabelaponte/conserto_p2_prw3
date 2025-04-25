package com.example.conserto_p2_prw3.controller;

import com.example.conserto_p2_prw3.model.dto.DadosCadastroConserto;
import com.example.conserto_p2_prw3.model.dto.ResumoConsertoDTO;
import com.example.conserto_p2_prw3.model.entities.Conserto;
import com.example.conserto_p2_prw3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConserto dados){
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("resumo")
    public List<ResumoConsertoDTO> getResumoConsertos() {
        return repository.findAll().stream().map(ResumoConsertoDTO::new).toList();
    }
}
