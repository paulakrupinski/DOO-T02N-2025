package CALCULADORA_GABRIELINHA;

public class Cliente {
    String nome;
    int idade;
   private Endereco endereco;


    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public  void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: "+ idade );
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    
}
