import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Cliente> listaClientes;
    private List<Vendedor> listaVendedores;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua,
                List<Cliente> listaClientes, List<Vendedor> listaVendedores) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.listaClientes = listaClientes;
        this.listaVendedores = listaVendedores;
    }

    public Loja() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
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

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void contarClientes() {
        System.out.println("\nQuantidade de clientes: " + listaClientes.size());
    }

    public void contarVendedores() {
        System.out.println("\nQuantidade de vendedores: " + listaVendedores.size());
    }

    public void apresentarse() {
        System.out.print("\nNome fantasia: " + this.nomeFantasia + "\nCNPJ: " + this.cnpj);
        System.out.println("\nCidade: " + this.cidade + "\nBairro: " + this.bairro + "\nRua: " + this.rua + "\n");
    }
}