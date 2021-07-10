package br.com.iraponan.orangetalentscomicsbookschallenge.service;

import br.com.iraponan.orangetalentscomicsbookschallenge.exceptions.CadastroUsuarioException;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.dto.UsuarioDto;
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
            List<Usuario> usuarios = usuarioRepositories.findAll();
            for (Usuario user : usuarios) {
                if (user.getEmail().equals(usuario.getEmail())){
                    throw new CadastroUsuarioException("Erro ao cadastrar novo usuário.\n" +
                            "E-mail: " + usuario.getEmail() + ", já cadastrado em nossa base.");
                }
                if (user.getCpf().equals(usuario.getCpf())) {
                    throw new CadastroUsuarioException("Erro ao cadastrar novo usuário.\n" +
                            "CPF: " + usuario.getCpf() + ", já cadastrados em nossa base.");
                }
            }
            throw new CadastroUsuarioException("Erro ao cadastrar novo usuário.\n" +
                    "Por favor verifique se você preencheu os campos corretamente.");
        }
    }

    public UsuarioDto getUsuario(Long id) throws CadastroUsuarioException {
        UsuarioDto usuarioDto = UsuarioDto.from(usuarioRepositories.findById(id).orElseThrow(() -> {
            return new CadastroUsuarioException("Usuário não encontrado.\nPor favor verifique o id do usuário passado.");
        }));
        return usuarioDto;
    }
}
