package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.config.Param;
import br.com.iraponan.orangetalentscomicsbookschallenge.exceptions.CadastrarComicException;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelAutoresItensDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.MarvelDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.UsuarioComicDto;
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

    public Comic comicSave(UsuarioComicDto usuarioComicDto) throws CadastrarComicException {
        try {
            Long ts = System.currentTimeMillis();
            MarvelDto marvelDto = marvelService.getComic(usuarioComicDto.getIdComic(), ts, Param.publicKey, Param.hashMd5(ts));
            Comic comic = setDadosComic(usuarioComicDto, marvelDto);
            comic = comicRepositories.save(comic);
            createAutores(marvelDto, comic);
            return comic;
        }
        catch (Exception e) {
            throw new CadastrarComicException("Erro ao salvar a Comic.\n" + e.getMessage());
        }
    }

    private Comic setDadosComic(UsuarioComicDto usuarioComicDto, MarvelDto marvelDto) throws CadastrarComicException {
        Comic comic = new Comic();
        Usuario usuario = usuarioRepositories.findById(usuarioComicDto.getIdUsuario()).orElseThrow(() -> {
            return new CadastrarComicException("Id do usuário informado não encontrado." +
                "\nPor favor verifique o id do usuário informado e tente novamente.");});
        comic.setComicId(marvelDto.getData().getResults().get(0).getId());
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
        ComicDto comicDto = ComicDto.from(comicRepositories.findById(id).orElseThrow(Exception::new));
        return  comicDto;
    }
}
