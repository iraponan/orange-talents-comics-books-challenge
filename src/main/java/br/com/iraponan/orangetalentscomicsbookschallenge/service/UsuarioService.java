package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.exceptions.CadastroUsuarioException;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.ComicDto;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    public Usuario usuarioSave(Usuario usuario) throws CadastroUsuarioException {
        try {
            return  usuarioRepositories.save(usuario);
        }
        catch (Exception e) {
            throw new CadastroUsuarioException("Erro ao cadastrar novo usuário.\n" +
                    "CPF: " + usuario.getCpf() + " ou " +
                    "E-mail: " + usuario.getEmail() + ", já cadastrados em nossa base.");
        }
    }

    public Usuario getUsuario(Long id) throws Exception {
        Usuario usuario = usuarioRepositories.findById(id).orElseThrow(Exception::new);
        List<Comic> comics = usuario.getComics();
        comics.forEach(comic -> {
            ComicDto comicDto = new ComicDto();
            comicDto.setPreco(comic.getPreco());
            comicDto.setIsbn(comic.getIsbn());
            comicDto.desconto(comicDto);
            comic.setPreco(comicDto.getPreco());
        });
        usuario.setComics(comics);
        return usuario;
    }
}
