package br.com.iraponan.orangetalentscomicsbookschallenge.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comic_books")
public class Comic {
    @Id
    @Column(nullable = false)
    private Long id_comics;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String autores;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Deprecated
    public Comic() {
    }

    public Comic(Long id_comics, String titulo, BigDecimal preco, String autores, String isbn, String descricao, Usuario usuario) {
        this.id_comics = id_comics;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Long getId_comics() {
        return id_comics;
    }

    public void setId_comics(Long id_comics) {
        this.id_comics = id_comics;
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

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id_comics=" + id_comics +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", autores='" + autores + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descricao='" + descricao + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
