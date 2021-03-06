package br.com.iraponan.orangetalentscomicsbookschallenge.controllers;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.UsuarioComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "comic")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PostMapping
    public ResponseEntity<?> cadastrarComic(@RequestBody UsuarioComicDto usuarioComicDto, UriComponentsBuilder builder) {
        try {
            URI uri = builder.path("/comic/{id}").buildAndExpand(comicService.comicSave(usuarioComicDto).getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ComicDto> getComic(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(comicService.getComic(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
