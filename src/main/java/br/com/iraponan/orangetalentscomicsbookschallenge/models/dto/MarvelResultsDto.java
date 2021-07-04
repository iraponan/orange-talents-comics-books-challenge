package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelResultsDto {

    private ComicDto comicDto;

    public MarvelResultsDto(ComicDto comicDto) {
        this.comicDto = comicDto;
    }

    public ComicDto getComicDto() {
        return comicDto;
    }
}
