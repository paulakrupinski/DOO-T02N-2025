package Alunos.FelipeHeringer.Aula07;

import java.util.Date;

public class ProcessarPedido {

    public ProcessarPedido() {

    }

    public void processarPedido(Pedido pedido) {
        System.out.println("Processando pedido...");
        System.out.println("ID do pedido: " + pedido.getPedidoId());
        System.out.println("Valor total: " + pedido.getValorTotalPedido());
        System.out.println("Data do pedido: " + pedido.getDataCriacao());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Vendedor: " + pedido.getVendedor().getNome());

        confirmarPagamento(pedido);
    }

    private void  confirmarPagamento(Pedido pedido) {
        Date dateNow = new Date();

        if (dateNow.after(pedido.getDataVencimentoReserva())){
            System.out.println("Pagamento não confirmado. O prazo de reserva expirou.");

        }else{
            System.out.println("Pagamento confirmado");
            pedido.setDataPagamento(dateNow);
            System.out.println("Data de pagamento: " + pedido.getDataPagamento());
        }
    }
}