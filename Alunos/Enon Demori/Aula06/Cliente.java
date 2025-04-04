package aula2;

public class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;
    
    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nome + ", Idade: " + idade;
    }
}
