package system;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    Item[] itens;
    
    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
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
            total += item.valor;
        }
        return total;
    }
    
    public void gerarDescricaoVenda() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("Pedido criado em: %s | Valor Total: R$%.2f\n", sdf.format(dataCriacao), calcularValorTotal());
    }
}