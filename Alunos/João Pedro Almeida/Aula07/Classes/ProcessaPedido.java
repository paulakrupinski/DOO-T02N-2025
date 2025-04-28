package Classes;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, 
                           Loja loja, List<Item> itens, int diasParaVencimento) {
        Date dataVencimento = new Date(dataCriacao.getTime() + (long) diasParaVencimento * 24 * 60 * 60 * 1000);
        Pedido pedido = new Pedido(id, dataCriacao, null, dataVencimento, cliente, vendedor, loja, itens);
        
        if (confirmarPagamento(pedido)) {
            pedido.dataPagamento = new Date();
        }
        
        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        return !hoje.after(pedido.dataVencimentoReserva);
    }
}