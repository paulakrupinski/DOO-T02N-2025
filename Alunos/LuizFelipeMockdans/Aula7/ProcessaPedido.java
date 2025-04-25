import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);

        if (confirmarPagamento(pedido)) {
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Pagamento não confirmado. Reserva vencida.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        return LocalDate.now().isBefore(pedido.getDataVencimentoReserva())
                || LocalDate.now().isEqual(pedido.getDataVencimentoReserva());
    }
}
