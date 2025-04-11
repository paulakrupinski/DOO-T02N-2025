package Aula07;

import java.util.Calendar;

public class logica {

    //Classe Loja 👇

    public void contarClientesLoja() {
        Loja loja = new Loja();
        System.out.println("Quantidade de clientes: " + loja.getListaDeClientes().size());
    }

    public void contarVendedoresLoja() {
        Loja loja = new Loja();
        System.out.println("Quantidade de vendedores: " + loja.getListaDeVendedores().size());
    }

    public void apresentarseLoja() {
        Loja loja = new Loja();
        System.out.println("Nome Fantasia: " + loja.getNomeFantasia());
        System.out.println("CNPJ: " + loja.getCnpj());
        System.out.println("Endereço: " + loja.getEndereco());
    }


}
