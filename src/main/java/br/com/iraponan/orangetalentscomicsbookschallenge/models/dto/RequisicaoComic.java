package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.service.ConsultarComic;

import java.math.BigDecimal;

public class RequisicaoComic {

    private Long id_comic;
    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;
    private Usuario usuario;

    public RequisicaoComic(Long id_comic, String titulo, BigDecimal preco, String autores, String isbn, String descricao, Usuario usuario) {
        this.id_comic = id_comic;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Long getId_comic() {
        return id_comic;
    }

    public void setId_comic(Long id_comic) {
        this.id_comic = id_comic;
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

    public void consultarComics(ConsultarComic consultarComic){

    }
}
