package Alunos.FelipeHeringer.Aula07.funcionarios;

import java.util.ArrayList;

import Alunos.FelipeHeringer.Aula07.Endereco;
import Alunos.FelipeHeringer.Aula07.Loja;

public class Vendedor extends Empregado{

    public Vendedor(String nome, Integer idade, Loja loja, Endereco endereco, Double salarioBase,
            ArrayList<Double> salarioRecebido) {

        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
        this.bonus = 0.2;
        salarioRecebido.add(salarioBase);
        salarioRecebido.add(salarioBase);
        salarioRecebido.add(salarioBase);
    }

    @Override
    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.println(this.nome + " é um vendedor e seu salário base é de: " + salarioBase);
    }
    
    @Override
    public void calcularBonusSalario () {
        Double salarioComBonus = salarioBase + (salarioBase * this.bonus);

        salarioRecebido.add(salarioComBonus);

        System.out.println("O salario este mês de " + this.nome + " com o bônus foi de: " + salarioComBonus);
    }    
}
