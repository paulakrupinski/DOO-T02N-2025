public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    Vendedor[] vendedores = new Vendedor[10];
    Cliente[] clientes = new Cliente[10];
    int contadorVendedores = 0;
    int contadorClientes = 0;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void adicionarVendedor(Vendedor v) {
        if (contadorVendedores < vendedores.length) {
            vendedores[contadorVendedores++] = v;
        }
    }

    public void adicionarCliente(Cliente c) {
        if (contadorClientes < clientes.length) {
            clientes[contadorClientes++] = c;
        }
    }

    public int contarClientes() {
        return contadorClientes;
    }

    public int contarVendedores() {
        return contadorVendedores;
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}
