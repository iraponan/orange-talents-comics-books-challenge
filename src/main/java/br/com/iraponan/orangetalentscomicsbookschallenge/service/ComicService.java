package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.ComicRepositories;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.UsuarioRepositories;
import org.springframework.stereotype.Service;

@Service
public class ComicService {

    private ComicRepositories comicRepositories;
    private UsuarioRepositories usuarioRepositories;

    public Comic comicSave(ComicDto comicDto) throws Exception {
        Comic comic = new Comic();
        Usuario usuario = usuarioRepositories.findById(comicDto.getIdUsuario()).orElseThrow(Exception::new);
        comic.setUsuario(usuario);
        try {
            return comicRepositories.save(comic);
        }
        catch (Exception e) {
            //TODO Criar classes exception para os erros em todo o projeto
            throw new Exception("Dados invalidos!");
        }
    }
}
