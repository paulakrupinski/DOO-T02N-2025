package Principal;

import Subclasses.Vendedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ProcessaPedido {
    private Pedido pedido;

    public ProcessaPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ProcessaPedido() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void processar() {
        ArrayList<Item> listaItens = new ArrayList<>();

        Endereco enderecoCliente = new Endereco("Paraná", "Cascavel", "Orquídeas", "Santa Fé",
                44, "Próximo ao mercado");
        Endereco enderecoVendedor = new Endereco("Paraná", "Cascavel", "Santa Maria", "General Osório",
                89, "Em frente a padaria");

        Date dataCriacao = new Date();
        Date dataPagamento = new Date();
        Date vencimentoReserva = new Date(dataCriacao.getTime() + 86400000L);

        Vendedor vendedor = new Vendedor("Marcos", 22, "My Plant", enderecoVendedor, 1500,
                Arrays.asList(3000.0, 3200.0, 3100.0));

        Cliente cliente = new Cliente("Rosa", 44, enderecoCliente);

        Item item = new Item(01, "Margarida", "Aquática", 45.50);
        listaItens.add(item);

        this.pedido = new Pedido(01, dataCriacao, dataPagamento, vencimentoReserva, cliente, vendedor,
                "My Plant", listaItens);
    }

    private void confirmarPagamento() {
        Date dataAgora = new Date();
        if (dataAgora.before(pedido.getVencimentoReserva())) {
            System.out.println("Pagamento bem sucedido.");
        }

        else {
            System.out.println("Pagamento recusado.");
        }
    }
}
