package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.config.Paran;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelAutoresItensDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.AutorRepositories;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.ComicRepositories;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {

    @Autowired
    private ComicRepositories comicRepositories;
    @Autowired
    private UsuarioRepositories usuarioRepositories;
    @Autowired
    private AutorRepositories autorRepositories;
    @Autowired
    private MarvelService marvelService;

    public Comic comicSave(ComicDto comicDto) throws Exception {
        MarvelDto marvelDto = marvelService.getComic(comicDto.getIdComic(), Paran.ts, Paran.publicKey, Paran.md5());
        Comic comic = setDadosComic(comicDto, marvelDto);
        try {
            comic = comicRepositories.save(comic);
            createAutores(marvelDto, comic);
            return comic;
        }
        catch (Exception e) {
            //TODO Criar classes exception para os erros em todo o projeto
            throw new Exception("Dados invalidos!");
        }
    }

    private Comic setDadosComic(ComicDto comicDto, MarvelDto marvelDto) throws Exception {
        Comic comic = new Comic();
        Usuario usuario = usuarioRepositories.findById(comicDto.getIdUsuario()).orElseThrow(Exception::new);
        comic.setUsuario(usuario);
        comic.setTitulo(marvelDto.getData().getResults().get(0).getTitle());
        comic.setPreco(marvelDto.getData().getResults().get(0).getPrices().get(0).getPrice());
        comic.setIsbn(marvelDto.getData().getResults().get(0).getIsbn());
        comic.setDescricao(marvelDto.getData().getResults().get(0).getDescription());
        return comic;
    }

    private void createAutores(MarvelDto marvelDto, Comic comic) {
        List<MarvelAutoresItensDto> autorList = marvelDto.getData().getResults().get(0).getCreators().getItems();
        autorList.forEach(it -> {
            Autor autor = new Autor();
            autor.setNome(it.getName());
            autor.setComic(comic);
            autorRepositories.save(autor);
        });
    }

    public Comic getComic(Long id) throws Exception {
        return comicRepositories.findById(id).orElseThrow(Exception::new);
    }
}
