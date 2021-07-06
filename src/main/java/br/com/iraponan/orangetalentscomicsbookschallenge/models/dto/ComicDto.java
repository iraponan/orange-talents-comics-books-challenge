package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import br.com.iraponan.orangetalentscomicsbookschallenge.models.Autor;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.Usuario;
import br.com.iraponan.orangetalentscomicsbookschallenge.models.enuns.DiasDaSemanaComDesconto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class ComicDto {

    @JsonIgnore
    private Usuario usuario;

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    @DecimalMin(value = "0.0")
    private BigDecimal preco;

    private List<Autor> autors;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    @NotBlank
    private String descricao;

    @JsonIgnore
    private boolean descontoAtivo = false;

    public ComicDto() {
    }

    public ComicDto(Usuario usuario, String titulo, BigDecimal preco, List<Autor> autors, String isbn, String descricao) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.preco = preco;
        this.autors = autors;
        this.isbn = isbn;
        this.descricao = descricao;
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

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
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

    public boolean isDescontoAtivo() {
        return descontoAtivo;
    }

    public void desconto(ComicDto comicDto) {
        this.descontoAtivo = possoDarDesconto();
        if (isDescontoAtivo()) {
            comicDto.preco = comicDto.preco.multiply(BigDecimal.valueOf(0.9));
        }
    }

    private boolean possoDarDesconto() {
        GregorianCalendar cal = new GregorianCalendar();
        boolean diaDaSemanaComdesconto = DiasDaSemanaComDesconto.valueOf(weekDay(cal).toUpperCase()).isDiaDeDesconto();
        if (diaDaSemanaComdesconto) {
            if (((this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("0")) ||
                    this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("1")) &&
                    (weekDay(cal).toUpperCase().equals(DiasDaSemanaComDesconto.SEG.toString()))) {
                return true;
            }
            if (((this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("2")) ||
                    this.getIsbn().substring(this.getIsbn().length()- 1, this.getIsbn().length()).equals("3")) &&
                    (weekDay(cal).toUpperCase().equals(DiasDaSemanaComDesconto.TER.toString()))) {
                return true;
            }
            if (((this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("4")) ||
                    this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("5")) &&
                    (weekDay(cal).toUpperCase().equals(DiasDaSemanaComDesconto.QUA.toString()))) {
                return true;
            }
            if (((this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("6")) ||
                    this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("7")) &&
                    (weekDay(cal).toUpperCase().equals(DiasDaSemanaComDesconto.QUI.toString()))) {
                return true;
            }
            if (((this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("8")) ||
                    this.getIsbn().substring(this.getIsbn().length() - 1, this.getIsbn().length()).equals("9")) &&
                    (weekDay(cal).toUpperCase().equals(DiasDaSemanaComDesconto.SEX.toString()))) {
                return true;
            }
        }
        return false;
    }

    private String weekDay(Calendar cal) {
        cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("pt", "BR"));
        return new DateFormatSymbols().getShortWeekdays()[cal.get(GregorianCalendar.DAY_OF_WEEK)];
    }
}
