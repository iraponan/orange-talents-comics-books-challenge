package br.com.iraponan.orangetalentscomicsbookschallenge.controllers;

import br.com.iraponan.orangetalentscomicsbookschallenge.exceptions.CadastroUsuarioException;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastroUsuario(@RequestBody @Valid Usuario usuario, UriComponentsBuilder builder) {
        try {
            URI uri = builder.path("/usuario/{id}").buildAndExpand(usuarioService.usuarioSave(usuario).getIdUsuario()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (CadastroUsuarioException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUsuario(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(usuarioService.getUsuario(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.\nPor favor verifique o id do usuário e tente novamente.");
        }
    }
}
