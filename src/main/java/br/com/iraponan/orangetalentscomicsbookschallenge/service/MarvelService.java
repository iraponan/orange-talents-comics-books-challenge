package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "comics", url = "http://gateway.marvel.com/v1/public/comics")
public interface MarvelService {

    @GetMapping(value = "{id}")
    MarvelDto getComic(@PathVariable(name = "id") Long id,
                       @RequestParam(name = "ts") Long ts,
                       @RequestParam(name = "apikey") String publicKey,
                       @RequestParam(name = "hash") String md5);
}
