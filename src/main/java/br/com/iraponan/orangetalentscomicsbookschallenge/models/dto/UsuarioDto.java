package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioDto {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Email(message = "E-mail Inválido.")
    private String email;

    @NotNull
    @NotBlank
    @CPF(message = "CPF Inválido.")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private @Past LocalDate dataNascimento;

    public UsuarioDto(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioDto() {
    }

    public UsuarioDto(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

//    public Usuario toUsuario() {
//        return new Usuario(nome, email, cpf, dataNascimento);
//    }
}
