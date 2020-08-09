package com.silvaHiago.minhasFinancas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvaHiago.minhasFinancas.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
	
	boolean existsByEmail(String email);
}
