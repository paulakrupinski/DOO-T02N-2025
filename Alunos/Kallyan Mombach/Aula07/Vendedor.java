package CALCULADORA_GABRIELINHA;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
     String nome;
    private int idade;
    private String loja;
    private Endereco endereco;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase, double... salarios) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;

        if (salarios == null || salarios.length == 0) {
            salarioRecebido.add(1000.0);
            salarioRecebido.add(1100.0);
            salarioRecebido.add(1200.0);
        } else {
            for (double salario : salarios) {
                salarioRecebido.add(salario);
            }
        }
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public void salarioVer() {
        System.out.println("Salário Base: R$  " + salarioBase + " Média dos Salários: R$ " + calcularMedia() + " Bônus: R$" + calcularBonus());
    }
}
