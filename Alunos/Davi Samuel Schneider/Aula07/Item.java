package domain;

public class Item {
    private String id, nome, tipo;
    private double valor;

    public Item(String id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + this.id + "\nNome: " + this.nome + "\nTipo: " + this.tipo + "\nValor: " + this.valor);
    }

    public double getValor() {
        return valor;
    }
}
