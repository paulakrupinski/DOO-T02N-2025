package pacote;
public class Pessoa {
String nome;
int idade;
Endereco endereco;
public Pessoa(String nome, int idade, Endereco endereco) {
	this.nome = nome;
	this.idade = idade;
	this.endereco = endereco;
}
public void apresentarse() {
   System.out.println("Nome: " + nome + ", Idade: " + idade);
   this.endereco.apresentarEndereco();
}
}


