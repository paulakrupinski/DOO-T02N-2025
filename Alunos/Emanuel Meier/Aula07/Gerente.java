package fag.objeto;

import java.util.List;

public class Gerente extends Funcionario{
	
	public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase,
			List<Double> salarioRecebido) {
		super(nome, idade, endereco, loja, salarioBase, salarioRecebido);
	}

	@Override
	public void apresentarSe() {
		System.out.println("Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja);
	}
	
	@Override
	public double calcularBonus() {
		return salarioBase * 0.35;
	}
}
