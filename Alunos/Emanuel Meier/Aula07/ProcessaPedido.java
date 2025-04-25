package fag.objeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Samambaia", "Planta", 50.00));
        itens.add(new Item(2, "Vaso de Cerâmica", "Acessório", 30.00));

        Date dataCriacao = new Date(); 
        Date dataPagamento = new Date(); 
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 86400000); // +1 dia

        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);

        if (confirmarPagamento(pedido)) {
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida! Pagamento não confirmado.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        return agora.before(pedido.getDataVencimentoReserva());
    }
}
