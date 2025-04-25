public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarCliente() {
        System.out.println("Cliente: " + nome);
        endereco.apresentarLogradouro();
    }
}