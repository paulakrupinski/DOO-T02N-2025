package aula2;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private Endereco endereco;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor() {
       
        salarioRecebido.add(2100.0);
    }

    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.loja = loja;
        
        salarioRecebido.add(salarioBase);
    }

    public double calcularMedia() {
       
        if (salarioRecebido.isEmpty()) {
            return 0; 
        }

    
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
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

    public double getSalarioBase() {
        return salarioBase;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia();
    }
}
