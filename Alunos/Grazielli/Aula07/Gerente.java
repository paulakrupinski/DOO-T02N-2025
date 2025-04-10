import java.util.Arrays;

public class Gerente extends Pessoa {
    Loja loja;
    double salarioBase;
    double[] salarioRecebido;

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarse() {
        System.out.println("Gerente: " + nome + " | Idade: " + idade + " | Loja: " + loja.nomeFantasia);
    }

    public double calcularMedia() {
        return Arrays.stream(salarioRecebido).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
