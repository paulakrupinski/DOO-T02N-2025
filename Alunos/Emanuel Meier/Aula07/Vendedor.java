package fag.objeto;

import java.util.List;

public class Vendedor extends Funcionario {
	
	public Vendedor(String nome, int idade, Endereco endereco, String loja, double salarioBase,
			List<Double> salarioRecebido) {
		super(nome, idade, endereco, loja, salarioBase, salarioRecebido);
	}

	@Override
	public void apresentarSe() {
		System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
	}
	
	@Override
	public double calcularBonus() {
		return salarioBase * 0.2;
	}
}
