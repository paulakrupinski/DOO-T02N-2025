package system;

public class Cliente {
    String nome;
    int idade;
    Endereco endereco;
    
    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    public void apresentaSe() {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade);
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
        System.out.println();
    }
}