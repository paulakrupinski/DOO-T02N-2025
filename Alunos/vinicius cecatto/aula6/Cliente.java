package aula6;

public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    // Método para apresentar o cliente
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}