package br.com.iraponan.orangetalentscomicsbookschallenge.controllers;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PostMapping
    public ResponseEntity<?> cadastrarComic(@RequestBody ComicDto comicDto, UriComponentsBuilder builder) {
        try {
            URI uri = builder.path("/comics/{id}").buildAndExpand(comicService.comicSave(comicDto).getIdComic()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
