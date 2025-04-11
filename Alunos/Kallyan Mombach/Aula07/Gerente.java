package CALCULADORA_GABRIELINHA;

import java.util.ArrayList;
import java.util.List;

public class Gerente {
    String nome;
    int idade;
    String loja;
    Endereco endereco;
    double salarioBase;
    List<Double> salarioRecebido = new ArrayList<>();

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase, double... salarios) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;

        if (salarios == null || salarios.length == 0) {
            salarioRecebido.add(3000.0);
            salarioRecebido.add(3200.0);
            salarioRecebido.add(3100.0);
        } else {
            for (double s : salarios) {
                salarioRecebido.add(s);
            }
        }
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double s : salarioRecebido) {
            soma += s;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

