package classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente {


    private String nome;
    private String cpf;
    private int idade;
    private int id;
    private List<Cliente>listaClientes;

    public Cliente(String nome, String cpf, int idade, int id, List<Cliente> listaClientes) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.id = id;
        this.listaClientes = listaClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }




}
