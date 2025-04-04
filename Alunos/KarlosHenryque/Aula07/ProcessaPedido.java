import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {
    public Pedido processar(int id, String cliente, String vendedor, String loja, List<Item> itens) {
        LocalDate hoje = LocalDate.now();
        Pedido pedido = new Pedido(id, hoje, hoje.plusDays(7), cliente, vendedor, loja);
        itens.forEach(pedido::adicionarItem);
        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        return !LocalDate.now().isAfter(pedido.dataVencimentoReserva);
    }
}