package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "comics", url = "http://gateway.marvel.com/v1/public")
public interface ConsultarComic {

//    @RequestMapping(value = "/comics/{comicId}/{url}", method = RequestMethod.GET)
//    List<RequisicaoComic> getAllComicsUser(@PathVariable(name = "comicId") Long id, @PathVariable(name = "url") String urlKey);
//
//    @RequestMapping(value = "/comics?ts={ts}&apikey={publicKey}&hash={md5}", method = RequestMethod.GET)
//    ResponseEntity<RequisicaoComic> getAllComics(@PathVariable(name = "ts") Long ts, @PathVariable(name = "publicKey") String publicKey, @PathVariable(name = "md5") String md5);
}
