package aula2;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Loja() {
       
    }
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + endereco.apresentarLogradouro();
    }
}
