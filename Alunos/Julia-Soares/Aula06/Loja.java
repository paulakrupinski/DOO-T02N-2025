public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    // Métodos set e get
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    // Método para contar a quantidade de clientes
    public void contarClientes() {
        if (clientes != null) {
            System.out.println("Quantidade de clientes: " + clientes.length);
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }

    // Método para contar a quantidade de vendedores
    public void contarVendedores() {
        if (vendedores != null) {
            System.out.println("Quantidade de vendedores: " + vendedores.length);
        } else {
            System.out.println("Nenhum vendedor cadastrado.");
        }
    }
}
