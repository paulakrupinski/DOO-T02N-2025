package Aula07;

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
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("\n===== Itens do Pedido =====");
        System.out.printf("%-5s %-20s %-15s %-10s\n", "ID", "Nome", "Tipo", "Valor (R$)");
        System.out.println("-----------------------------------------------------------");
            for (Item item : itens) {
                System.out.printf("%-5d %-20s %-15s R$%-10.2f\n", 
                item.getId(), item.getNome(), item.getTipo(), item.getValor());
            }
            
        System.out.println("Pedido criado em: " + dataCriacao + " | Total: R$" + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}
