package aula6;

import java.util.ArrayList;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        // Valores pré-definidos de salários recebidos
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2600.0);
        this.salarioRecebido.add(2700.0);
    }

    // Método para apresentar o vendedor
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    // Método para calcular a média dos salários recebidos
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    // Método para calcular o bônus
    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}