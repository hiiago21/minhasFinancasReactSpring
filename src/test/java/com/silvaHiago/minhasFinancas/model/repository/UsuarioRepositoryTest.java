package com.silvaHiago.minhasFinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.silvaHiago.minhasFinancas.model.entities.Usuario;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveVerificarEmailExistente() {
		Usuario user = criarUsuario();
		entityManager.persist(user);

		boolean result = repository.existsByEmail("hiiago@yahoo.com");

		Assertions.assertThat(result).isTrue();
	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {

		boolean result = repository.existsByEmail("hiiago@yahoo.com");

		Assertions.assertThat(result).isFalse();
	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		Usuario user = criarUsuario();
		
		Usuario userSalvo = repository.save(user);

		Assertions.assertThat(userSalvo.getId()).isNotNull();
	}

	@Test
	public void deveBuscarUmUsuarioPorEmail() {

		Usuario userSalvo = criarUsuario();
		entityManager.persist(userSalvo);
		
		Optional<Usuario> result = repository.findByEmail("hiiago@yahoo.com");
		
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioAoBuscarEmailNaoExistente() {
		
		Optional<Usuario> result = repository.findByEmail("hiiago@yahoo.com");
		
		Assertions.assertThat(result.isPresent()).isFalse();
	}
	
	public static Usuario criarUsuario() {
		 Usuario user = Usuario.builder().nome("Hiago Silva").email("hiiago@yahoo.com").senha("hiaogo").build();
		 return user;
	}
}
