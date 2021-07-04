package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelDto {

    private MarvelDataDto data;

    public MarvelDto(MarvelDataDto data) {
        this.data = data;
    }

    public MarvelDataDto getData() {
        return data;
    }
}
