package com.silvaHiago.minhasFinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.silvaHiago.minhasFinancas.model.entities.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")

public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarEmail() {
		Usuario user = Usuario.builder().nome("Hiago Silva").email("hiiago@yahoo.com").senha("hiaogo").build();
		repository.save(user);
		
		boolean result = repository.existsByEmail("hiiago@yahoo.com");
		
		Assertions.assertThat(result).isTrue();
	}
}
