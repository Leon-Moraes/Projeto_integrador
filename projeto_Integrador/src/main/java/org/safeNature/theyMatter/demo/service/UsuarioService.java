package org.safeNature.theyMatter.demo.service;

import org.safeNature.theyMatter.demo.model.UsuariosTable;
import org.safeNature.theyMatter.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioService {
	
	@Autowired
	private UsuariosRepository repository;
	
	public UsuariosTable CadastrarUsuario(UsuariosTable usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		// Método de criptocrafia do tipo hash que comprime o tamanho do dado
		
		String senhaEncoder = encoder.encode(usuario.getPassword());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}

}
