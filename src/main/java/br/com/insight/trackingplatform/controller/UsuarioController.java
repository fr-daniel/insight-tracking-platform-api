package br.com.insight.trackingplatform.controller;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import br.com.insight.trackingplatform.model.Usuario;
import br.com.insight.trackingplatform.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = this.usuarioService.buscarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> adicionarUsuario(@RequestBody Usuario usuario) throws InsightTrackingPlatformException {
        Map<String, Object> usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity deletarUsuario(@PathVariable("usuarioId") Integer usuarioId) throws InsightTrackingPlatformException {
        usuarioService.excluirUsuario(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario)  throws InsightTrackingPlatformException {
        usuarioService.atualizarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> buscarUsuarioPeloId(@PathVariable("usuarioId") Integer usuarioId) throws InsightTrackingPlatformException {
        Usuario usuario = usuarioService.buscarUsuarioPeloId(usuarioId);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
