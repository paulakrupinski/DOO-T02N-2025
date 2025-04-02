<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
<<<<<<< HEAD
    public Vendedor[] vendedores;
    public Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, int numVendedores, int numClientes) {
=======
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
<<<<<<< HEAD
        this.vendedores = new Vendedor[numVendedores];
        this.clientes = new Cliente[numClientes];
    }

    public void adicionarVendedor(Vendedor vendedor, int index) {
        if (index >= 0 && index < vendedores.length) {
            vendedores[index] = vendedor;
        }
    }

    public void adicionarCliente(Cliente cliente, int index) {
        if (index >= 0 && index < clientes.length) {
            clientes[index] = cliente;
        }
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("Razao Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereco: " + rua + ", " + bairro + ", " + cidade);
    }

    public void contarClientes() {
        System.out.println("Quantidade de clientes cadastrados: " + clientes.length);
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores cadastrados: " + vendedores.length);
    }
=======
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereco: " + cidade + ", " + bairro + ", " + rua);
    }

    public String getNomeFantasia() { return nomeFantasia; }
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
}
