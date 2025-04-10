package system;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Endereco endereco;
    Cliente[] clientes;
    Vendedor[] vendedores;
    
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco, Cliente[] clientes, Vendedor[] vendedores) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.clientes = clientes;
        this.vendedores = vendedores;
    }
    
    public void contarClientes() {
        System.out.printf("\nQuantidade de clientes: %d", clientes.length);
    }
    
    public void contarVendedores() {
        System.out.printf("\nQuantidade de vendedores: %d", vendedores.length);
    }
    
    public void apresentaSe() {
        System.out.printf("\nLoja: %s\nCNPJ: %s\nEndereço: ", nomeFantasia, cnpj);
        endereco.apresentarLogradouro();
        System.out.println();
    }
}
