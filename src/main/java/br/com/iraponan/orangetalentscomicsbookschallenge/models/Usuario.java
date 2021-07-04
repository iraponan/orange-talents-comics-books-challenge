package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String nome;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Email(message = "E-mail Inválido.")
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotBlank
    @CPF(message = "CPF Inválido.")
    private String cpf;

    @Column(nullable = false)
    private @Past Date dataNascimento;

    @OneToMany(mappedBy = "usuario")
    private List<Comic> comicsList;

    @Deprecated
    public Usuario() {
    }

    public Usuario(@NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email, @NotNull @NotBlank @CPF String cpf, @Past Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId_usuario() {
        return id_usuario;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Comic> getComicsList() {
        return comicsList;
    }

    public void setComicsList(List<Comic> comicsList) {
        this.comicsList = comicsList;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
