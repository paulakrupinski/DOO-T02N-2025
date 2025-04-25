package domain;

public class Gerente extends Vendedor{

    public Gerente(String nome, int idade, double salarioBase, Endereco endereco) {
        super(nome, idade, salarioBase, endereco);
    }

    @Override
    public double calcularBonus() {
        return  salarioBase * 0.35;
    }
}
