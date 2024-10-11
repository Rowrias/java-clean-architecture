package br.com.alura.codechella.application.gateways;

import java.util.List;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public interface RepositorioDeUsuario {
	default Usuario cadastrarUsuario(Usuario usuario) {
		return null;
	}

    default List<Usuario> listarTodos(){
    	return null;
    }
}
