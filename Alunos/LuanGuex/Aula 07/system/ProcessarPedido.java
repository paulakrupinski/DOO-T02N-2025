package system;

import java.util.Date;

public class ProcessarPedido {
    
    public Pedido processar(Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Date hoje = new Date();
        Date dataPagamento = hoje;
        Date dataVencimentoReserva = new Date(hoje.getTime() + 3L * 24 * 60 * 60 * 1000);
        Pedido pedido = new Pedido(1, hoje, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);

        if(confirmarPagamento(pedido.dataVencimentoReserva)) {
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
        }
        return pedido;
    }
    
    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date agora = new Date();
        return agora.compareTo(dataVencimentoReserva) <= 0;
    }
    
    public void testeConfirmarPagamento() {
        Date futuro = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        Date passado = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
        
        System.out.print("Teste (futuro): ");
        System.out.println(confirmarPagamento(futuro) ? "Pago" : "Não pago");
        
        System.out.print("Teste (passado): ");
        System.out.println(confirmarPagamento(passado) ? "Pago" : "Não pago");
    }
}