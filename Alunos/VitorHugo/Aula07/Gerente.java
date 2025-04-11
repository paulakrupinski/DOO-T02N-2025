package Aula07;

import java.util.Arrays;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private Endereco endereco;
    private double salarioBase;
    private double[] salarioRecebido;

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase + 500, salarioBase + 700, salarioBase + 600};
    }

    public void apresentarse() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return Arrays.stream(salarioRecebido).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
