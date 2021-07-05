package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import java.util.List;

public class MarvelDataDto {

    private List<MarvelComicDto> results;

    public MarvelDataDto(List<MarvelComicDto> results) {
        this.results = results;
    }

    public MarvelDataDto() {
    }

    public List<MarvelComicDto> getResults() {
        return results;
    }

    public void setResults(List<MarvelComicDto> results) {
        this.results = results;
    }
}
