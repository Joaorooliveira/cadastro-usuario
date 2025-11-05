package br.com.joaov.cadastrousuario.controller;

import br.com.joaov.cadastrousuario.business.UsuarioService;
import br.com.joaov.cadastrousuario.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioService usuarioService;



    @PostMapping
    @Transactional
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
}
