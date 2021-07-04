package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired //Estudar
    private UsuarioRepositories usuarioRepositories;

    public Usuario usuarioSave(Usuario usuario) throws Exception {
        try {
            return  usuarioRepositories.save(usuario);
        }
        catch (Exception e) {
            throw new Exception("Dados invalidos!");
        }
    }

    public Usuario getUsuario(Long id) throws Exception {
        return usuarioRepositories.findById(id).orElseThrow(Exception::new);
    }
}
