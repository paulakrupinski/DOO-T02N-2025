package Classes;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    public String loja;
    public double salarioBase;
    public List<Double> salariosRecebidos;

    public Funcionario(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();

        salariosRecebidos.add(salarioBase * 0.8);
        salariosRecebidos.add(salarioBase * 0.9);
        salariosRecebidos.add(salarioBase);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2; 
    }
}