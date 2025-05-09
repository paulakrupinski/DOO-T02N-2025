import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private int idade;
    private List<Cliente> listaDeCliente;
    private List<Quarto> listaDeQuarto;

    public Cliente(){
        listaDeCliente = new ArrayList<>();
        listaDeQuarto = new ArrayList<>();
    }

    public Cliente(String nome, int idade, List<Cliente> listaDeClientes) {
        this.nome = nome;
        this.idade = idade;
        this.listaDeCliente = listaDeClientes;
    }

    public List<Quarto> getListaDeQuarto() {
        return listaDeQuarto;
    }

    public void setListaDeQuarto(List<Quarto> listaDeQuarto) {
        this.listaDeQuarto = listaDeQuarto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeCliente;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeCliente = listaDeClientes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
