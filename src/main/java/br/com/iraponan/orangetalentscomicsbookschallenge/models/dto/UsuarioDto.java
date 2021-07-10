package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDto {

    @NotNull(message = "Nome não pode ser nulo.")
    @NotBlank(message = "Nome não pode estar em branco.")
    private String nome;

    @NotNull(message = "E-mail não pode ser nulo.")
    @NotBlank(message = "E-mail não pode estar em branco.")
    @Email(message = "E-mail Inválido.")
    private String email;

    @NotNull(message = "CPF não pode ser nulo.")
    @NotBlank(message = "CPF não pode estar em branco.")
    @CPF(message = "CPF Inválido.")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private @Past LocalDate dataNascimento;

    private List<ComicDto> comicDtos;

    public UsuarioDto() {
    }

    public UsuarioDto(String nome, String email, String cpf, LocalDate dataNascimento, List<ComicDto> comicDtos) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.comicDtos = comicDtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ComicDto> getComicDtos() {
        return comicDtos;
    }

    public void setComicDtos(List<ComicDto> comicDtos) {
        this.comicDtos = comicDtos;
    }

    public static UsuarioDto from(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setCpf(usuario.getCpf());
        usuarioDto.setDataNascimento(usuario.getDataNascimento());
        List<ComicDto> comicDtos = new ArrayList<>();
        for (Comic comic : usuario.getComics()) {
            comicDtos.add(ComicDto.from(comic));
        }
        usuarioDto.setComicDtos(comicDtos);
        return usuarioDto;
    }

}
