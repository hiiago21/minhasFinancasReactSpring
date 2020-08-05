package com.silvaHiago.minhasFinancas.services.imple;

import org.springframework.stereotype.Service;

import com.silvaHiago.minhasFinancas.exceptions.RegraNegocioException;
import com.silvaHiago.minhasFinancas.model.entities.Usuario;
import com.silvaHiago.minhasFinancas.model.repository.UsuarioRepository;
import com.silvaHiago.minhasFinancas.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{
	
	
	private UsuarioRepository repository;	

	public UsuarioServiceImp(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		
		if(repository.existsByEmail(email)) {
			throw new RegraNegocioException("Já existe este email no sistema!");
		}
		
	}

}
