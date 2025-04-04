
import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
    }

    public void adicionarSalario(double salario) {
        salariosRecebidos.add(salario);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return salariosRecebidos.isEmpty() ? 0 : soma / salariosRecebidos.size();
    }

    public void calcularBonus() {
        System.out.println("Bônus: " + (salarioBase * 0.2));
    }

    @Override
    public String toString() {
        return "Vendedor [nome=" + nome + ", idade=" + idade + ", loja=" + loja + ", cidade=" + cidade + ", bairro="
                + bairro + ", rua=" + rua + ", salarioBase=" + salarioBase + ", salariosRecebidos=" + salariosRecebidos + "]";
    }
}

