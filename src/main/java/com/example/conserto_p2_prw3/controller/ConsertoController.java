package com.example.conserto_p2_prw3.controller;

import com.example.conserto_p2_prw3.model.dto.AtualizaConsertoDTO;
import com.example.conserto_p2_prw3.model.dto.CadastroConsertoDTO;
import com.example.conserto_p2_prw3.model.dto.DetalhamentoConsertoDTO;
import com.example.conserto_p2_prw3.model.dto.ResumoConsertoDTO;
import com.example.conserto_p2_prw3.model.entities.Conserto;
import com.example.conserto_p2_prw3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoConsertoDTO> cadastrar(@RequestBody @Valid CadastroConsertoDTO dados,
                                                             UriComponentsBuilder uriBuilder){
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);

        URI uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoConsertoDTO(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listar(Pageable pageable) {
        Page<Conserto> allConsertos = repository.findAll(pageable);
        return ResponseEntity.ok(allConsertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getById(@PathVariable Long id) {
        Optional<Conserto> optionalConserto = repository.findById(id);

        if(optionalConserto.isPresent()){
            Conserto conserto = optionalConserto.get();
            return ResponseEntity.ok(conserto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("resumo")
    public ResponseEntity<List<ResumoConsertoDTO>> getResumoConsertos() {
        List<ResumoConsertoDTO> allConsertos = repository.findAllByAtivoTrue().stream().map(ResumoConsertoDTO::new).toList();
        return ResponseEntity.ok(allConsertos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> atualizar(@RequestBody @Valid AtualizaConsertoDTO dados) {
        Optional<Conserto> conserto = repository.findById(dados.id());

        if (conserto.isPresent()) {
            conserto.get().atualizarDados(dados);
            return ResponseEntity.ok(new DetalhamentoConsertoDTO(conserto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id);

        if (conserto.isPresent()) {
            conserto.get().excluir();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
