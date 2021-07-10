package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import java.util.List;

public class MarvelComicDto {

    private Long id;
    private String title;
    private List<MarvelPrecoDto> prices;
    private MarvelAutoresDto creators;
    private String isbn;
    private String description;

    public MarvelComicDto(Long id, String title, List<MarvelPrecoDto> prices, MarvelAutoresDto creators, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.prices = prices;
        this.creators = creators;
        this.isbn = isbn;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MarvelPrecoDto> getPrices() {
        return prices;
    }

    public void setPrices(List<MarvelPrecoDto> prices) {
        this.prices = prices;
    }

    public MarvelAutoresDto getCreators() {
        return creators;
    }

    public void setCreators(MarvelAutoresDto creators) {
        this.creators = creators;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
