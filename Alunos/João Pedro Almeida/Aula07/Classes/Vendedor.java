package Classes;

public class Vendedor extends Funcionario {
    public Vendedor(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco, loja, salarioBase);
    }

    @Override
    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }
}