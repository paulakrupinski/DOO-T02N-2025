package CALCULADORA_GABRIELINHA;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {
    
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens,
                            Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva) {
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Reserva vencida! Pagamento não pode ser processado.");
            return null;
        }

        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        System.out.println("Pedido processado com sucesso!");
        pedido.gerarDescricaoVenda();
        return pedido;
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return !hoje.after(dataVencimentoReserva);
    }
}
