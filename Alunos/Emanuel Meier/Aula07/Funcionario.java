package fag.objeto;

import java.util.List;

public abstract class Funcionario extends Pessoa{
	protected String loja;
	protected double salarioBase;
	protected List<Double> salarioRecebido;
	
	public Funcionario(String nome, int idade, Endereco endereco, String loja, double salarioBase,
			List<Double> salarioRecebido) {
		super(nome, idade, endereco);
		this.loja = loja;
		this.salarioBase = salarioBase;
		this.salarioRecebido = salarioRecebido;
	}
	
	public double calcularMedia() {
		if (salarioRecebido.isEmpty()) return 0.0;
		
		double soma = 0;
		for (double salario : salarioRecebido) {
			soma += salario;
		}
		return soma / salarioRecebido.size();
	}
	
	public abstract double calcularBonus();
}
