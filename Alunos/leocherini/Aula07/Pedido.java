package myplant;

import java.util.Date;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private Item[] itens;
    
    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, String loja, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }
    
    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < itens.length; i++) {
            total = total + itens[i].getValor();
        }
        return total;
    }
    
    public void gerarDescricaoVenda() {
        System.out.println("Pedido ID: " + id + " | Data de Criação: " + dataCriacao + " | Valor Total: R$ " + calcularValorTotal());
    }
    
    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}