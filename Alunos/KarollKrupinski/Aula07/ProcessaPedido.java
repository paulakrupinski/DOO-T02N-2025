package Aula07;

import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, ArrayList<Item> itens) {
        Pedido pedido = new Pedido(id, new Date(), cliente, vendedor, loja, itens);
        confirmarPagamento(pedido);
        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        if (hoje.before(pedido.getDataVencimentoReserva())) {
            pedido.setDataPagamento(hoje);
            return true;
        }
        return false;
    }
}