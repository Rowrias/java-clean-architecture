package br.com.alura.codechella.infra.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	void save(UsuarioEntity entity);

	UsuarioEntity findByCpf(String cpf);
}
