package com.silvaHiago.minhasFinancas.services;

import com.silvaHiago.minhasFinancas.model.entities.Usuario;

public interface UsuarioService {
		
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
}
