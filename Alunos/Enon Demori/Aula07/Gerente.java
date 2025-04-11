package aula2;

public class Gerente {
    private String nome;
    private int idade;
    private Loja loja;
    private Endereco endereco;
    private double salarioBase;
    private double[] salarioRecebido = {4000.0, 4300.0, 4100.0};

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
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

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Loja getLoja() {
        return loja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    @Override
    public String toString() {
        return "Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia();
    }
}

