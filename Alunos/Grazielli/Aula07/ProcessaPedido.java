
import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente,
            Vendedor vendedor, Loja loja, Item[] itens) {
        if (confirmarPagamento(dataVencimentoReserva)) {
            return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
            return null;
        }
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        return new Date().before(dataVencimentoReserva);
    }
}
