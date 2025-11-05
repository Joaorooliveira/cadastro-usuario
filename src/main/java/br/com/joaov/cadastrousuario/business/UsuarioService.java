package br.com.joaov.cadastrousuario.business;

import br.com.joaov.cadastrousuario.infrastructure.entities.Usuario;
import br.com.joaov.cadastrousuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository ;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email nao encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Long id ,Usuario usuario) {
        var usuarioEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario nao encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail()!=null?usuario.getEmail():usuarioEntity.getEmail())
                .nome(usuario.getNome()!=null?usuario.getNome():usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }
}
