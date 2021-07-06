package br.com.iraponan.orangetalentscomicsbookschallenge.models.enuns;

public enum DiasDaSemanaComDesconto {
    DOM(false),
    SEG(true),
    TER(true),
    QUA(true),
    QUI(true),
    SEX(true),
    SÁB(false);

    boolean diaDeDesconto;

    DiasDaSemanaComDesconto(boolean diaDeDesconto) {
        this.diaDeDesconto = diaDeDesconto;
    }

    public boolean isDiaDeDesconto() {
        return diaDeDesconto;
    }
}
