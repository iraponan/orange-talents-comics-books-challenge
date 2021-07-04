package br.com.iraponan.orangetalentscomicsbookschallenge.enuns;

public enum DiasDaSemanaComDesconto {
    DOMINGO(false),
    SEGUNDA(true),
    TERÇA(true),
    QUARTA(true),
    QUINTA(true),
    SEXTA(true),
    SÁBADO(false);

    boolean diaDeDesconto;

    DiasDaSemanaComDesconto(boolean diaDeDesconto) {
        this.diaDeDesconto = diaDeDesconto;
    }

    public boolean isDiaDeDesconto() {
        return diaDeDesconto;
    }
}
