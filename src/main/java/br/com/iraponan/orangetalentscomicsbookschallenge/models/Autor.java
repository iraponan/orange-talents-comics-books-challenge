package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idAutor;

    @ManyToOne
    @JsonIgnore
    private Comic comic;

    @Column(nullable = false)
    private String nome;

    public Autor() {
    }

    public Autor(Comic comic, String nome) {
        this.comic = comic;
        this.nome = nome;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
