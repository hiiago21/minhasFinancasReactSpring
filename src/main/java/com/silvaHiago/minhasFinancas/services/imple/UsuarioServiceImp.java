package com.silvaHiago.minhasFinancas.services.imple;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silvaHiago.minhasFinancas.exceptions.ErroAutenticacao;
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
		
		Optional<Usuario> user = repository.findByEmail(email);
		
		if(!user.isPresent()) {
			throw new ErroAutenticacao("Email não cadastrado!");
		}
		
		if(user.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida!");
		}
		
		return user.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		
		validarEmail(usuario.getEmail());
		
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		
		if(repository.existsByEmail(email)) {
			throw new RegraNegocioException("Já existe este email no sistema!");
		}
		
	}

}
