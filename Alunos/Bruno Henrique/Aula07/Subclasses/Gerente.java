package Subclasses;

import java.util.List;

import Principal.Endereco;
import Superclasses.Funcionario;

public class Gerente extends Funcionario {

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase,
                   List<Double> salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    public Gerente() {
    }

    @Override
    public void apresentar() {
        System.out.println("--Dados gerente--");
        super.apresentar();
    }

    @Override
    public void calcularMedia() {
        System.out.println("--Media gerente--");
        super.calcularMedia();
    }

    @Override
    public void calcularBonus(){
        double bonus = this.salarioBase * 0.35;
        System.out.println("Bônus gerente: " + bonus);
    }

}
