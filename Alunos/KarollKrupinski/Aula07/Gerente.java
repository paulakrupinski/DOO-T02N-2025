package Aula07;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido;

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase, salarioBase * 1.1, salarioBase * 1.2};
    }

    @Override
    public void apresentarse() {
        System.out.println("Meu nome é " + nome + ", tenho " + idade + " anos e trabalho na loja " + loja + ".");
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    public String getLoja() { return loja; }
    public double getSalarioBase() { return salarioBase; }
    public double[] getSalarioRecebido() { return salarioRecebido; }
}