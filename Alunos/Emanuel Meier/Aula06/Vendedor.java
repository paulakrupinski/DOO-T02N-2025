package fag.objeto;

import java.util.Arrays;

public class Vendedor {
	private String nome;
	private int idade;
	private String loja;
	private String cidade;
	private String bairro;
	private String rua;
	private double salarioBase;
	private double[] salarioRecebido;
	
	public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double[] salarioRecebido) {
		
		this.nome = nome;
		this.idade = idade;
		this.loja = loja;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.salarioBase = salarioBase;
		this.salarioRecebido = salarioRecebido;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}



	public String getLoja() {
		return loja;
	}



	public void setLoja(String loja) {
		this.loja = loja;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public double getSalarioBase() {
		return salarioBase;
	}



	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}



	public double[] getSalarioRecebido() {
		return salarioRecebido;
	}



	public void setSalarioRecebido(double[] salarioRecebido) {
		this.salarioRecebido = salarioRecebido;
	}



	public void apresentarSe() {
		System.out.println("Nome: " + nome + " | Idade: " + idade + " | Loja: " + loja);
	}
	
	public double calcularMedia() {
		return Arrays.stream(salarioRecebido).average().orElse(0);
	}
	
	public double calcularBonus() {
		return salarioBase * 0.2;
	}
	
}
