import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, Item[] itens, Date dataCriacao, Date dataVencimento) {
        if (confirmarPagamento(dataVencimento)) {
            return new Pedido(id, dataCriacao, new Date(), dataVencimento, cliente, vendedor, loja, itens);
        } else {
            System.out.println("Reserva vencida. Pagamento não pode ser processado.");
            return null;
        }
    }

    private boolean confirmarPagamento(Date dataVencimento) {
        Date hoje = new Date();
        return !hoje.after(dataVencimento);
    }
}