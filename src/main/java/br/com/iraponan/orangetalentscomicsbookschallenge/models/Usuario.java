package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    @NotNull(message = "Nome não pode ser nulo.")
    @NotBlank(message = "Nome não pode estar em branco.")
    private String nome;

    @Column(nullable = false, unique = true)
    @NotNull(message = "E-mail não pode ser nulo.")
    @NotBlank(message = "E-mail não pode estar em branco.")
    @Email(message = "E-mail Inválido.")
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull(message = "CPF não pode ser nulo.")
    @NotBlank(message = "CPF não pode estar em branco.")
    @CPF(message = "CPF Inválido.")
    private String cpf;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private @Past LocalDate dataNascimento;

    @OneToMany
    @JoinColumn(name = "usuario_id_usuario")
    private List<Comic> comics;

    public Usuario() {
    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento, List<Comic> comics) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.comics = comics;
    }

    public Long getIdUsuario() {
        return idUsuario;
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

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
}
