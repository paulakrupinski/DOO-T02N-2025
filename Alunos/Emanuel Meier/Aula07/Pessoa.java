package fag.objeto;

public abstract class Pessoa {
	protected String nome;
	protected int idade;
	public Endereco endereco;
	
	public Pessoa(String nome, int idade, Endereco endereco) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	public abstract void apresentarSe();
	
	public Endereco getEndereco() {
	    return endereco;
	}
}
