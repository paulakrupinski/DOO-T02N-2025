package pacote;
import java.util.Date;
import java.util.List; 
public class ProcessaPedido {
  
   public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
       if (confirmarPagamento(dataPagamento, dataVencimentoReserva)) {
           return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
       }
       System.out.println("Pagamento não confirmado.");
       return null;
   }
   private boolean confirmarPagamento(Date dataPagamento, Date dataVencimentoReserva) {
       return !dataPagamento.after(dataVencimentoReserva);
   }
}
