package com.silvaHiago.minhasFinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvaHiago.minhasFinancas.model.entities.Lancamentos;

public interface LancamentoRepository extends JpaRepository<Lancamentos, Long>{

}
