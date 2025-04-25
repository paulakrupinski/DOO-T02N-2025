package Principal;

import Subclasses.Vendedor;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date vencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private List<Item> listaItens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date vencimentoReserva, Cliente cliente,
                  Vendedor vendedor, String loja, List<Item> listaItens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.vencimentoReserva = vencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.listaItens = listaItens;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getVencimentoReserva() {
        return vencimentoReserva;
    }

    public void setVencimentoReserva(Date vencimentoReserva) {
        this.vencimentoReserva = vencimentoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public List<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public double calcularTotal() {
        double soma = 0;

        for (Item iterator : listaItens) {
            soma = soma + iterator.getValor();
        }

        return soma;
    }

    public void descreverVenda() {
        System.out.println("Data de criação do pedido: " + dataCriacao);
        System.out.println("Valor total do pedido: " + calcularTotal());
    }
}
