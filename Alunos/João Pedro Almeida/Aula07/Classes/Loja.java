package Classes;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    public String nomeFantasia;
    public String razaoSocial;
    public String cpnj;
    public Endereco endereco;
    public List<Vendedor> vendedores = new ArrayList<>();
    public List<Gerente> gerentes = new ArrayList<>();
    public List<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cpnj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cpnj = cpnj;
        this.endereco = endereco;
    }

    public void contarClientes() {
        System.out.println("Total de clientes: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Total de vendedores: " + vendedores.size());
    }

    public void contarGerentes() {
        System.out.println("Total de gerentes: " + gerentes.size());
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cpnj);
        endereco.apresentarLogradouro();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}