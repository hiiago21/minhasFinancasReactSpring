package com.silvaHiago.minhasFinancas.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.silvaHiago.minhasFinancas.exceptions.RegraNegocioException;
import com.silvaHiago.minhasFinancas.model.entities.Usuario;
import com.silvaHiago.minhasFinancas.model.repository.UsuarioRepository;
import com.silvaHiago.minhasFinancas.services.imple.UsuarioServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	UsuarioService service;
	UsuarioRepository repository;
	
	@Before
	public void setUp() {
		 repository = Mockito.mock(UsuarioRepository.class); 
		 service = new UsuarioServiceImp(repository);
	}
	
	@Test
	public void deveValidarEmail() {
		
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		service.validarEmail("hiiago@yahoo.com");
	}
	
	@Test
	public void deveLancarErroQuandoValidarEmail() {
		Usuario user = Usuario.builder().nome("Hiago Silva").email("hiiago@yahoo.com").senha("hiaogo").build();
		repository.save(user);
		
		
		try{
			service.validarEmail("hiiago@yahoo.com");
		}
		catch (RegraNegocioException e) {
			Assert.assertEquals(e.getMessage(), "Já existe este email no sistema!");
		}
		
		
	}
}
