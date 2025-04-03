import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    
    public Loja() {
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public int contarVendedores() {
        return vendedores.size();
    }


    public int contarClientes() {
        return clientes.size();
    }


    public void apresentarse() {
        System.out.println("Nome Fantasia: " + (nomeFantasia != null ? nomeFantasia : "Não informado"));
        System.out.println("CNPJ: " + (cnpj != null ? cnpj : "Não informado"));
        System.out.println("Endereço: " + formatarEndereco());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        exibirResumo();

        if (!vendedores.isEmpty()) {
            System.out.println("-=-=-=-=-=-=-=- Vendedores -=-=-=-=-=-=-=-=-");
            vendedores.forEach(Vendedor::apresentarse);
        } else {
            System.out.println("Nenhum vendedor cadastrado.");
        }

        if (!clientes.isEmpty()) {
            System.out.println("-=-=-=-=-=-=-=- Clientes -=-=-=-=-=-=-=-=-");
            clientes.forEach(Cliente::apresentarse);
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }


    private String formatarEndereco() {
        return (cidade != null ? cidade : "Cidade não informada") + ", " +
               (bairro != null ? bairro : "Bairro não informado") + ", " +
               (rua != null ? rua : "Rua não informada");
    }

    public void exibirResumo() {
        System.out.println("Total de Clientes: " + contarClientes());
        System.out.println("Total de Vendedores: " + contarVendedores());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void cadastraVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void cadastraCliente(Cliente cliente) {
        clientes.add(cliente);
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

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
