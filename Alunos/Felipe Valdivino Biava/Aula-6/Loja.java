import java.util.ArrayList;
import java.util.List;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<String>listaDeVendedores = new ArrayList<>();
    private List<String>listaDeClientes = new ArrayList<>();

    public Loja(){

    }

    public Loja(String nomeFantasia, String razaoSocial, int cnpj, String cidade, String bairro, String rua, List<String> listaDeVendedores, List<String> listaDeClientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.listaDeVendedores = listaDeVendedores;
        this.listaDeClientes = listaDeClientes;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public List<String> getListaDeVendedores() {
        return listaDeVendedores;
    }

    public void setListaDeVendedores(List<String> listaDeVendedores) {
        this.listaDeVendedores = listaDeVendedores;
    }

    public List<String> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<String> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj=" + cnpj +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", listaDeVendedores=" + listaDeVendedores +
                ", listaDeClientes=" + listaDeClientes +
                '}';
    }

    public void adicionarCliente(Cliente cliente1) {
    }

    public void adicionarVendedor(Vendedor vendedor1) {
    }
}
