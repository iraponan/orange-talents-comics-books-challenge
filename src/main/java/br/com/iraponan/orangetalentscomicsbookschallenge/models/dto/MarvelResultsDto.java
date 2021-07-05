package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelResultsDto {

    private MarvelComicDto marvelComicDto;

    public MarvelResultsDto(MarvelComicDto marvelComicDto) {
        this.marvelComicDto = marvelComicDto;
    }

    public MarvelResultsDto() {
    }

    public MarvelComicDto getMarvelComicDto() {
        return marvelComicDto;
    }

    public void setMarvelComicDto(MarvelComicDto marvelComicDto) {
        this.marvelComicDto = marvelComicDto;
    }
}
