package domain;

public enum TipoQuarto {
    SIMPLES(1),
    DUPLO(2);

    private final int valor;

    TipoQuarto(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
