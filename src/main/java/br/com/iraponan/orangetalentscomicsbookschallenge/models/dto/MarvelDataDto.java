package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelDataDto {

    private MarvelResultsDto results;

    public MarvelDataDto(MarvelResultsDto results) {
        this.results = results;
    }

    public MarvelResultsDto getResults() {
        return results;
    }
}
