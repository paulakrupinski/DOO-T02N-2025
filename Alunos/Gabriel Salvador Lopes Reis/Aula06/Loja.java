import java.util.ArrayList;
import java.util.List;

/*3. Crie uma classe Loja com:
- Atributos, nome fantasia, razão social, cpnj, cidade, bairro, rua, array vendedores, array de clientes.
- contarClientes, mosta a quantidade de clientes
- contarVendedores, mosta a quantidade de vendedores.
- Método apresentarse, printa nomeFantasia, cnpj e endereco*/
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
        vendedores = new ArrayList<Vendedor>();
        clientes = new ArrayList<Cliente>();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public int contarClientes() {
        return clientes.size();
    }

    public void apresentarse() {
        System.out.println("Nome: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Edereço: " + cidade + ", " + bairro + ", " + rua);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println("-=-=-=-=-=-=-=- Vendedores -=-=-=-=-=-=-=-=-");
        vendedores.forEach(Vendedor::apresentarse);

        System.out.println("-=-=-=-=-=-=-=- Clientes -=-=-=-=-=-=-=-=-");
        clientes.forEach(Cliente::apresentarse);
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
