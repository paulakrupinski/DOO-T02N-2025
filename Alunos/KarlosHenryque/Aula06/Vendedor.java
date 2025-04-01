import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade, bairro, rua;
    double salarioBase;
    List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2600.0);
        this.salarioRecebido.add(2550.0);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
