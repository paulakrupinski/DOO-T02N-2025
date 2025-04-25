public class Cliente {
    private String nome;
    private String endereco;

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Endereço: " + endereco);
    }
}
