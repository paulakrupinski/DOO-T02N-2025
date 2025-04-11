package calculadoraplantas;

import java.util.Date;

public class ProcessaPedido{
        
        public Pedido processar(int id, Date dataCriacao, Date dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens){
            Pedido pedido = new Pedido();
            pedido.id = id;
            pedido.dataCriacao = dataCriacao;
            pedido.dataVencimentoReserva = dataVencimentoReserva;
            pedido.cliente = cliente;
            pedido.vendedor = vendedor;
            pedido.loja = loja;
            pedido.itens = itens;
            
            if(confirmarPagamento(pedido)){
                pedido.dataPagamento = new Date();
                System.out.println("Pagamento confirmado!");
            } else {
                System.out.println("Pagamento recusado: reserva vencida.");
            }
            return pedido;
        }
        
        private boolean confirmarPagamento(Pedido pedido){
            Date hoje = new Date();
            return hoje.compareTo(pedido.dataVencimentoReserva) <= 0;
        }
        
    }