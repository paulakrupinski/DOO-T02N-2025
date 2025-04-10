package Subclasses;

import Principal.Endereco;
import Superclasses.Funcionario;

import java.util.List;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase,
                    List<Double> salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    public Vendedor() {
    }

    @Override
    public void apresentar() {
        System.out.println("--Dados vendedor--");
        super.apresentar();
    }

    @Override
    public void calcularMedia() {
        System.out.println("--Media vendedor--");
        super.calcularMedia();
    }

    @Override
    public void calcularBonus(){
        double bonus = this.salarioBase * 0.2;
        System.out.println("Bônus vendedor: " + bonus);
    }
}
