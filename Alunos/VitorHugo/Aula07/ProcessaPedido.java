package Aula07;

import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, Item[] itens,
                            Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva) {
        if (confirmarPagamento(dataVencimentoReserva)) {
            return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        } else {
            System.out.println("Pagamento não confirmado: reserva vencida.");
            return null;
        }
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return hoje.before(dataVencimentoReserva) || hoje.equals(dataVencimentoReserva);
    }
}
