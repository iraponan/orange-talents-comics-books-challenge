package br.com.iraponan.orangetalentscomicsbookschallenge.models.dto;

import java.math.BigDecimal;

public class MarvelPrecoDto {

    private BigDecimal price;

    public MarvelPrecoDto(BigDecimal price) {
        this.price = price;
    }

    public MarvelPrecoDto() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
