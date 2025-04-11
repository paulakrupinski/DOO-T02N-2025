package Aula07;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private List<Cliente>listaDeCliente;

    public Cliente(){
        listaDeCliente = new ArrayList<>();
    }

    public Cliente(String nome, int idade, Endereco endereco) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setEndereco(endereco);
    }

    public Cliente(String joão, int i, String cidadeA, String bairroX, String s) {
    }

    private String setNome() {
        return null;
    }

    public List<Cliente> getListaDeCliente() {
        return listaDeCliente;
    }

    public void setListaDeCliente(List<Cliente> listaDeCliente) {
        this.listaDeCliente = listaDeCliente;
    }

    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public int getIdade() {
        return super.getIdade();
    }

    public void setIdade(int idade) {
        super.setIdade(idade);
    }

    public Endereco getEndereco() {
        return super.getEndereco();
    }

    public void setEndereco(Endereco endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public void apresentarse() {
        System.out.println("Cliente = [" +
                "nome='" + getNome()+ '\'' +
                ", idade=" + getIdade() +
                ']');
    }


    //Classe Cliente 👇

}
