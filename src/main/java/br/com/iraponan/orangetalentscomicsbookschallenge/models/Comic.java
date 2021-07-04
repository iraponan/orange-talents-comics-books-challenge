package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "comic_books")
public class Comic {
    @Id
    @Column(nullable = false)
    private Long id_comic;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    @DecimalMin(value = "0.0")
    private BigDecimal preco;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String descricao;

    @OneToMany
    @JoinColumn(name = "comic_id_comic")
    private List<Autor> autor;

    @Deprecated
    public Comic() {
    }

    public Comic(String titulo, BigDecimal preco, String isbn, String descricao, List<Autor> autor) {
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId_comic() {
        return id_comic;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }
}
