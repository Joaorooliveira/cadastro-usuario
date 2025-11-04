package br.com.joaov.cadastrousuario.infrastructure.repository;

import br.com.joaov.cadastrousuario.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
