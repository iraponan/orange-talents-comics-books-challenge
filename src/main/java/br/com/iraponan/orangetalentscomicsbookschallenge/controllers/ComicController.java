package br.com.iraponan.orangetalentscomicsbookschallenge.controllers;

import br.com.iraponan.orangetalentscomicsbookschallenge.config.Paran;
import br.com.iraponan.orangetalentscomicsbookschallenge.service.ConsultarComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comics")
public class ComicController {

    @Autowired
    private ConsultarComic consultarComic;

//    private RequisicaoComic requisicaoComic = new RequisicaoComic(1L, "Teste", new BigDecimal(0.0),
//            "Autores Teste", "12345678-9", "Descrição Teste", new Usuario("Nome do Usuario", "teste@teste.com", "074.906.284-31", new Date()));

    public ComicController(ConsultarComic consultarComic) {
        this.consultarComic = consultarComic;
    }

    @GetMapping
    public void getAllComincs() {
        ResponseEntity<?> responseEntity = consultarComic.getAllComics(Paran.ts, Paran.publicKey, Paran.md5());
        System.out.println(responseEntity.getStatusCode().toString());
    }

//    @GetMapping
//    public RequisicaoComic getAllComics() {
//        return requisicaoComic;
//    }
}
