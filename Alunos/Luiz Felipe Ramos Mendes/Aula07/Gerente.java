import java.util.ArrayList;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(2500.00);
        this.salarioRecebido.add(2600.00);
        this.salarioRecebido.add(2700.00);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
