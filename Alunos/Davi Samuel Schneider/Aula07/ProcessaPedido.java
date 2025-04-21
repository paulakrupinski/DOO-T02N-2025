package domain;

import java.util.Date;

public class ProcessaPedido {


    public Pedido processar(String id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Item[] itens) {
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
            return null;
        }
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, itens);
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return !hoje.after(dataVencimentoReserva);
    }
}
