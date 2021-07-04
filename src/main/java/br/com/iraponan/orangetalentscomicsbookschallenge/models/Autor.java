package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;

    @ManyToOne
    @JsonIgnore
    private Comic comic;

    @Column(nullable = false)
    private String nome;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
