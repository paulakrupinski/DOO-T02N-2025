import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;
    private Endereco endereco;

    public Gerente(String nome, int idade, String loja, double salarioBase, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.endereco = endereco;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(5000.0);
        this.salarioRecebido.add(5200.0);
        this.salarioRecebido.add(5300.0);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}