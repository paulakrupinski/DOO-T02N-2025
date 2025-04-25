package pacote;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
    String loja;
    double salarioBase;
    List<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase, double... salarios) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;

        if (salarios.length < 3) {
            this.salarioRecebido.add(1000.0);
            this.salarioRecebido.add(1100.0);
            this.salarioRecebido.add(1200.0);
        } else {
            for (double salario : salarios) {
                this.salarioRecebido.add(salario);
            }
        }
    }

    @Override
    public void apresentarse() {
        super.apresentarse();
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return salarioRecebido.isEmpty() ? 0 : soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
