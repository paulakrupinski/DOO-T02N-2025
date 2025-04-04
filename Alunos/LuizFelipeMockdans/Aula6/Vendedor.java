import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private List<Double> salarioRecebido;
    private Loja loja;

    public Vendedor(String nome, int idade, Loja loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = 1500.00;
        this.salarioRecebido = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            salarioRecebido.add(salarioBase);
        }
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void calcularMedia() {
        double total = salarioRecebido.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Média Salarial: " + (total / salarioRecebido.size()));
    }

    public void calcularBonus() {
        double bonus = 0.2 * salarioBase;
        double novoSalario = salarioBase + bonus;
        salarioRecebido.add(novoSalario);
        System.out.println("Salário com bônus: " + novoSalario);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Loja getLoja() {
        return loja;
    }
}
