package Entities;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
	private String nome;
	private int idade;
	
	
	List <Clientes> listaClientes = new ArrayList<>();
	
	public Clientes() {
		
	}


	public Clientes(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
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


	@Override
	public String toString() {
		return "Nome: " + nome + ", Idade: " + idade + "\n";
	}
	
	public void addCliente (Clientes cliente) {
		listaClientes.add(cliente);
	}
	
	public void printaClientes() {
		for(Clientes cliente : listaClientes) {
			System.out.println(cliente);
		}
	}
}
