package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "comic_books")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long comicId;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    @DecimalMin(value = "0.0")
    private BigDecimal preco;

    @OneToMany
    //@JoinColumn(name = "comic_id")
    private List<Autor> autor;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false, columnDefinition="TEXT")
    private String descricao;

    public Comic() {
    }

    public Comic(Long comicId, Usuario usuario, String titulo, BigDecimal preco, List<Autor> autor, String isbn, String descricao) {
        this.comicId = comicId;
        this.usuario = usuario;
        this.titulo = titulo;
        this.preco = preco;
        this.autor = autor;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
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

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
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
}
