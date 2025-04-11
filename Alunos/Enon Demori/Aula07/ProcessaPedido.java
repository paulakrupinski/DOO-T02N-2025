package aula2;

import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens, Date dataVencimentoReserva) {
        Pedido pedido = new Pedido();
        pedido.id = id;
        pedido.dataCriacao = new Date();
        pedido.dataVencimentoReserva = dataVencimentoReserva;
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.loja = loja;
        pedido.itens = itens;

        if (confirmarPagamento(pedido.dataVencimentoReserva)) {
            pedido.dataPagamento = new Date();
        } else {
            System.out.println("Pagamento não confirmado. A reserva venceu.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Date dataVencimento) {
        Date hoje = new Date();
        return hoje.before(dataVencimento) || hoje.equals(dataVencimento);
    }
}