package aula2;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente() {
        
    }
    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", Idade: " + idade + ", Endereço: " + endereco.apresentarLogradouro();
    }
}
