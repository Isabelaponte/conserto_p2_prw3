package com.example.conserto_p2_prw3.repository;

import com.example.conserto_p2_prw3.model.entities.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
