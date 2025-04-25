package Aula07;

import java.util.Date;
import java.util.List;

public class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Pessoa cliente;
    Pessoa vendedor;
    String loja;
    List<Item> itens;

    Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Pessoa cliente, Pessoa vendedor, String loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }
}
