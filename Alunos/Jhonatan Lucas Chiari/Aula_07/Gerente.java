import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private Loja loja;
    private Endereco endereco;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();

        salarioRecebido.add(5000.0);
        salarioRecebido.add(5500.0);
        salarioRecebido.add(6000.0);
    }

    public void apresentarse() {
        System.out.println("-------- DADOS DO GERENTE --------");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
        System.out.println("Salários Recebidos: " + salarioRecebido);
        System.out.println("----------------------------------\n");
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35; // Gerente ganha 35% de bônus
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }
}
