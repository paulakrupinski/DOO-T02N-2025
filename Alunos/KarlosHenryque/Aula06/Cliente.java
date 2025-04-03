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

    public void apresentarse() {
<<<<<<< HEAD
        System.out.println("Cliente: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
    }
}
=======
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

    // Getters
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
