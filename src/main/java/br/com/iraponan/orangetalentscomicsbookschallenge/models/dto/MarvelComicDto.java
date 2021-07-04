package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelComicDto {

    private String title;
    private MarvelPrecoDto price;
    private MarvelAutoresDto creators;
    private String isbn;
    private String description;

    public MarvelComicDto(String title, MarvelPrecoDto price, MarvelAutoresDto creators, String isbn, String description) {
        this.title = title;
        this.price = price;
        this.creators = creators;
        this.isbn = isbn;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public MarvelPrecoDto getPrice() {
        return price;
    }

    public MarvelAutoresDto getCreators() {
        return creators;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }
}
