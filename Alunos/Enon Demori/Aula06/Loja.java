package aula2;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
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
    
    public List<Vendedor> getVendedores() {
        return vendedores;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    @Override
    public String toString() {
        return "Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " 
                + cidade + ", " + bairro + ", " + rua;
    }
}
