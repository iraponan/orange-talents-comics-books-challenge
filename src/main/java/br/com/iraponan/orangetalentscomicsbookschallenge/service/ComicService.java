package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.config.Param;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.UsuarioComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelAutoresItensDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.AutorRepositories;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.ComicRepositories;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Comic comicSave(UsuarioComicDto usuarioComicDto) throws Exception {
        MarvelDto marvelDto = marvelService.getComic(usuarioComicDto.getIdComic(), Param.ts, Param.publicKey, Param.hashMd5());
        Comic comic = setDadosComic(usuarioComicDto, marvelDto);
        try {
            comic = comicRepositories.save(comic);
            createAutores(marvelDto, comic);
            return comic;
        }
        catch (Exception e) {
            throw new Exception("Não foi possível cadastrar a Comic.");
        }
    }

    private Comic setDadosComic(UsuarioComicDto usuarioComicDto, MarvelDto marvelDto) throws Exception {
        Comic comic = new Comic();
        Usuario usuario = usuarioRepositories.findById(usuarioComicDto.getIdUsuario()).orElseThrow(Exception::new);
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

    public ComicDto getComic(Long id) throws Exception {
        Comic comic = comicRepositories.findById(id).orElseThrow(Exception::new);
        ComicDto comicDto = new ComicDto();
        comicDto.setUsuario(comic.getUsuario());
        comicDto.setTitulo(comic.getTitulo());
        comicDto.setPreco(comic.getPreco());
        comicDto.setAutors(comic.getAutor());
        comicDto.setIsbn(comic.getIsbn());
        comicDto.setDescricao(comic.getDescricao());
        comicDto.desconto(comicDto);
        return comicDto;
    }
}
