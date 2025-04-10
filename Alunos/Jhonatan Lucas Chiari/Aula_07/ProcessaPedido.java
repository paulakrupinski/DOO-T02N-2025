import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {

        if (reservaDentroDoPrazo(dataVencimentoReserva)) {
            Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
            System.out.println("Pedido processado com sucesso!");
            return pedido;
        } else {
            System.out.println("Erro: reserva vencida. Pedido não processado.");
            return null;
        }
    }

    private boolean reservaDentroDoPrazo(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return !hoje.after(dataVencimentoReserva);
    }
}
