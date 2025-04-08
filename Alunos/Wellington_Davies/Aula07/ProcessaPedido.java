import java.time.LocalDate;
import java.util.ArrayList;

public class ProcessaPedido {

    private Pedido pedido;

    public Pedido getPedido() {
        return this.pedido;
    }

    public void processar(int id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva, Cliente cliente,
        Vendedor vendedor, String loja, ArrayList<Item> listaDeItens) {
            
        this.pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, listaDeItens);
        confirmarPagamento();
    }

    // Método privado para verificar vencimento da reserva
    private void confirmarPagamento() {
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(pedido.getDataVencimentoReserva())) {
            System.out.println("Reserva vencida! Pagamento não confirmado.");
        } else {
            System.out.println(" Pagamento confirmado. Reserva ainda válida.");
        }
    }

}
