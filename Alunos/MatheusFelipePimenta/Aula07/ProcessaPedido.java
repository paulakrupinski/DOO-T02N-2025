package Aula07;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {
    Pedido processar(int id, Pessoa cliente, Pessoa vendedor, String loja, List<Item> itens, Date dataVencimentoReserva) {
        Date agora = new Date();
        boolean pagamentoConfirmado = confirmarPagamento(dataVencimentoReserva, agora);

        Date dataPagamento = pagamentoConfirmado ? agora : null;

        return new Pedido(id, agora, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date vencimento, Date atual) {
        return atual.before(vencimento);
    }
}
