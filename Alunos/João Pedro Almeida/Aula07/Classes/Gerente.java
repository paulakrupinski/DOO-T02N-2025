package Classes;

public class Gerente extends Funcionario {
    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco, loja, salarioBase);
    }

    @Override
    public void apresentarse() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}