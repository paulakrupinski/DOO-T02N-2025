
public class Cliente {
    private String nome;
    private int idade;
    private String cpf;

    public Cliente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void exibirInfo(){
        System.out.println("Nome: "+ nome);
        System.out.println("idade: " +idade);
        System.out.println("CPF: "+ cpf);
    }

    
}
