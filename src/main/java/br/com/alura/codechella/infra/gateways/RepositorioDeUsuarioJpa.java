package br.com.alura.codechella.infra.gateways;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistance.UsuarioEntity;
import br.com.alura.codechella.infra.persistance.UsuarioRepository;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;
    
    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }
    
    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
    	UsuarioEntity entity = mapper.toEntity(usuario);
    	repositorio.save(entity);
        return mapper.toDomain(entity);        
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repositorio.findByCpf(cpf);
        if (entity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            repositorio.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluiUsuario(String cpf) {
        UsuarioEntity entity = repositorio.findByCpf(cpf);
        repositorio.deleteById(entity.getId());
    }
}
