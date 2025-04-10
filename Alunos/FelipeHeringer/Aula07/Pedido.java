package Alunos.FelipeHeringer.Aula07;

import java.util.ArrayList;
import java.util.Date;

import Alunos.FelipeHeringer.Aula07.funcionarios.Vendedor;

public class Pedido {
    private Integer pedidoId;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private ArrayList<Item> itens;
    private Double valorTotalPedido;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.pedidoId = 0;
    }

    public Double calcularValorTotalPedido () {
        Double valorTotal = 0.0;

        for (Item item : itens) {
            valorTotal += item.getValor() * item.getQuantidade();
        }

        this.valorTotalPedido = valorTotal;

        return valorTotalPedido;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação do Pedido: " + dataCriacao + " Valor Total do Pedido: " +  getValorTotalPedido().toString() );
    }

    public void adicionarItensAoPedido(Item item) {
        itens.add(item);
    } 

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId() {
        this.pedidoId = pedidoId +=1;
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

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
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

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(Double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }
    
    
}

