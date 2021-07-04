package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.RequisicaoComic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comics", url = "http://gateway.marvel.com/v1/public")
public interface ConsultarComic {

    @RequestMapping(value = "/comics/{comicId}/{url}", method = RequestMethod.GET)
    List<RequisicaoComic> getAllComicsUser(@PathVariable(name = "comicId") Long id, @PathVariable(name = "url") String urlKey);

    @RequestMapping(value = "/comics?ts={ts}&apikey={publicKey}&hash={md5}", method = RequestMethod.GET)
    ResponseEntity<RequisicaoComic> getAllComics(@PathVariable(name = "ts") Long ts, @PathVariable(name = "publicKey") String publicKey, @PathVariable(name = "md5") String md5);
}
