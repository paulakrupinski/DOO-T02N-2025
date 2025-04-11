package Aula07;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private Endereco endereco;
    private List<Vendedor>listaDeVendedores;
    private List<Cliente>listaDeClientes;

    public Loja(){
        listaDeVendedores = new ArrayList<>();
        listaDeClientes = new ArrayList<>();
    }

    public Loja(String nomeFantasia, String razaoSocial, int cnpj, Endereco endereco, String cidade, String bairro, String rua, List<String> listaDeVendedores, List<String> listaDeClientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Vendedor> getListaDeVendedores() {
        return listaDeVendedores;
    }

    public void setListaDeVendedores(List<Vendedor> listaDeVendedores) {
        this.listaDeVendedores = listaDeVendedores;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj=" + cnpj +
                ", listaDeVendedores=" + listaDeVendedores +
                ", listaDeClientes=" + listaDeClientes +
                '}';
    }

    public void adicionarCliente(Cliente cliente1) {
    }

    public void adicionarVendedor(Vendedor vendedor1) {
    }
}
