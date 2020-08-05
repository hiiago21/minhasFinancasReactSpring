package com.silvaHiago.minhasFinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvaHiago.minhasFinancas.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

	boolean existsByEmail(String email);
}
