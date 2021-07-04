package br.com.iraponan.orangetalentscomicsbookschallenge.view;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "comic", url = "http://gateway.marvel.com/v1/public")
public interface ComicFeing {

    @GetMapping(value = "/comics")
    public List<Comic> getAllComics();
}
