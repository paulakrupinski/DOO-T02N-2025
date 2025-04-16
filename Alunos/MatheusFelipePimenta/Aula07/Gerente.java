package Aula07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gerente extends Pessoa {
    List<Double> salarioRecebido;

    public Gerente(String nome, Endereco endereco) {
        super(nome, endereco);
        this.salarioRecebido = new ArrayList<>(Arrays.asList(4500.0, 4600.0, 4700.0));
    }

    public double calcularMediaSalarial() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }
}
