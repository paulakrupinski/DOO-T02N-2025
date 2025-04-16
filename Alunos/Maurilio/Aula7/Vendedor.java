public class Vendedor extends Pessoa {
    public Vendedor(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarVendedor() {
        System.out.println("Vendedor: " + nome);
        endereco.apresentarLogradouro();
    }
}