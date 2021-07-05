package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import java.util.List;

public class MarvelAutoresDto {

    private List<MarvelAutoresItensDto> items;

    public MarvelAutoresDto(List<MarvelAutoresItensDto> items) {
        this.items = items;
    }

    public MarvelAutoresDto() {
    }

    public List<MarvelAutoresItensDto> getItems() {
        return items;
    }

    public void setItems(List<MarvelAutoresItensDto> items) {
        this.items = items;
    }
}
