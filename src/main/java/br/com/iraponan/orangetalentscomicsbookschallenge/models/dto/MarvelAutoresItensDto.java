package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

public class MarvelAutoresItensDto {

    private String name;

    public MarvelAutoresItensDto(String name) {
        this.name = name;
    }

    public MarvelAutoresItensDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
