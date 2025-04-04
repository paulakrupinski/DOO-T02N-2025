import java.util.ArrayList;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, int cnpj, String cidade, String bairro, String rua, 
    ArrayList<Cliente> clientes, ArrayList<Vendedor> vendedores) {
    this.nomeFantasia = nomeFantasia;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.cidade = cidade;
    this.bairro = bairro;
    this.rua = rua;
    this.clientes = clientes; 
    this.vendedores = vendedores; 
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

    public ArrayList getVendedores() {
        return vendedores;
    }

    public void setVendedores(ArrayList vendedores) {
        this.vendedores = vendedores;
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public void apresentarse() {
        System.out.println("LOJA");
        System.out.println("----------------------------");
        System.out.println("Nome da loja: "+ nomeFantasia);
        System.out.println("CNPJ: "+ cnpj);
        System.out.println("Cidade: "+ cidade);
        System.out.println("Bairro: "+ bairro);
        System.out.println("Rua: "+ rua);
        System.out.println("----------------------------\n");
    }

    public void listarVendedores() {
        System.out.println("Lista de Vendedores:");
        for (Vendedor vendedor : vendedores) {
            int contador = 0;
            System.out.println("Vendedor "+ contador + 1+":" +" Nome " + vendedor.getNome() + ", Idade: " + vendedor.getIdade() + ", Loja: " + vendedor.getLoja());
        }
        System.out.println("\n");
    }

    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            int contador = 0;
            System.out.println("Cliente " + contador +1 + ":" +" Nome "+ cliente.getNome() + ", Idade: " + cliente.getIdade() + ", Cidade: " + cliente.getCidade());
        }
        System.out.println("\n");
    }
         
}
