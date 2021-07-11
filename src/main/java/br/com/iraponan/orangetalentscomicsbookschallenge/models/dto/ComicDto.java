package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Comic;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.enums.DiasDaSemanaComDesconto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class ComicDto {

    @JsonIgnore
    private Usuario usuario;

    @NotNull
    @NotBlank
    private Long comicId;

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    @DecimalMin(value = "0.0")
    private BigDecimal preco;

    private List<Autor> autores;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    @NotBlank
    private String descricao;

    private String diaDeDesconto;

    private Boolean descontoAtivo = false;

    public ComicDto() {
    }

    public ComicDto(Usuario usuario, Long comicId, String titulo, BigDecimal preco, List<Autor> autores, String isbn, String descricao, String diaDeDesconto, Boolean descontoAtivo) {
        this.usuario = usuario;
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.diaDeDesconto = diaDeDesconto;
        this.descontoAtivo = descontoAtivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
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

    public String getDiaDeDesconto() {
        return diaDeDesconto;
    }

    public void setDiaDeDesconto(String diaDeDesconto) {
        this.diaDeDesconto = diaDeDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(Boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }

    private String isbnDiasComDesconto(ComicDto comicDto) {
        if (this.getIsbn() == null || this.getIsbn().equals("")){
            return "";
        }
        String finalIsbn = comicDto.getIsbn().substring(comicDto.getIsbn().length() - 1);
        if (finalIsbn.equals("0") || finalIsbn.equals("1")) {
            return DiasDaSemanaComDesconto.SEG.getDiaDeDesconto();
        }
        if (finalIsbn.equals("2") || finalIsbn.equals("3")) {
            return DiasDaSemanaComDesconto.TER.getDiaDeDesconto();
        }
        if (finalIsbn.equals("4") || finalIsbn.equals("5")) {
            return DiasDaSemanaComDesconto.QUA.getDiaDeDesconto();
        }
        if (finalIsbn.equals("6") || finalIsbn.equals("7")) {
            return DiasDaSemanaComDesconto.QUI.getDiaDeDesconto();
        }
        if (finalIsbn.equals("8") || finalIsbn.equals("9")) {
            return DiasDaSemanaComDesconto.SEX.getDiaDeDesconto();
        }
        return "";
    }

    private void aplicandoDesconto(ComicDto comicDto) {
        this.setDescontoAtivo(possoDarDesconto());;
        if (getDescontoAtivo()) {
            comicDto.preco = comicDto.preco.multiply(BigDecimal.valueOf(0.9));
        }
    }

    private boolean possoDarDesconto() {
        DiasDaSemanaComDesconto diaDaSemanaComdesconto = DiasDaSemanaComDesconto.valueOf(shortWeekDay());
        if (this.getIsbn() == null || this.getIsbn().equals("")){
            return false;
        }
        String finalIsbn = this.getIsbn().substring(this.getIsbn().length() - 1);
        return Arrays.asList(diaDaSemanaComdesconto.getFinalIsbn()).contains(finalIsbn);
    }

    private String shortWeekDay() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")).toUpperCase();
    }

    public static ComicDto from(Comic comic) {
        ComicDto comicDto = new ComicDto();
        comicDto.setUsuario(comic.getUsuario());
        comicDto.setComicId(comic.getComicId());
        comicDto.setTitulo(comic.getTitulo());
        comicDto.setPreco(comic.getPreco());
        comicDto.setAutores(comic.getAutor());
        comicDto.setIsbn(comic.getIsbn());
        comicDto.setDescricao(comic.getDescricao());
        comicDto.setDiaDeDesconto(comicDto.isbnDiasComDesconto(comicDto));
        comicDto.aplicandoDesconto(comicDto);
        return comicDto;
    }
}
