public class Cliente extends Pessoa {
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade);
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("------ DADOS DO CLIENTE ------");
        System.out.println("Meu nome é: " + getNome());
        System.out.println("Minha idade é: " + getIdade());
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
        System.out.println("-----------------------------\n");
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
