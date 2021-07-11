package br.com.iraponan.orangetalentscomicsbookschallenge.models.enums;

public enum DiasDaSemanaComDesconto {
    DOM(new String[] {}, ""),
    SEG(new String[] {"0", "1"}, "Segunda-Feira"),
    TER(new String[] {"2", "3"}, "Terça-Feira"),
    QUA(new String[] {"4", "5"}, "Quarta-Feira"),
    QUI(new String[] {"6", "7"}, "Quinta Feira"),
    SEX(new String[] {"8", "9"}, "Sexta-Feira"),
    SÁB(new String[] {}, "");

    String[] finalIsbn;
    String diaDeDesconto;

    DiasDaSemanaComDesconto(String[] finalIsbn) {
        this.finalIsbn = finalIsbn;
    }

    DiasDaSemanaComDesconto(String[] finalIsbn, String diaDeDesconto) {
        this.finalIsbn = finalIsbn;
        this.diaDeDesconto = diaDeDesconto;
    }

    public String[] getFinalIsbn() {
        return finalIsbn;
    }

    public String getDiaDeDesconto() {
        return diaDeDesconto;
    }
}
