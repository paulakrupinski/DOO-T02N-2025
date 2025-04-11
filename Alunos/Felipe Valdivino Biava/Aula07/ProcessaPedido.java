package Aula07;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public ProcessaPedido(Date dataVencimentoReserva, boolean pagamentoConfirmado) {
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.pagamentoConfirmado = false;
    }

    public ProcessaPedido() {

    }

    public Pedido processar(Cliente cliente, Vendedor vendedor, Loja loja, List<Venda> listaDeItens){
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente.getNome());
        pedido.setVendedor(vendedor.getNome());
        pedido.setLoja(loja.getNomeFantasia());
        pedido.setDate(new Date());
        pedido.setListaDeItens(listaDeItens);


        return pedido;
    }

    private Date dataVencimentoReserva;
    private boolean pagamentoConfirmado;

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public boolean isPagamentoConfirmado() {
        return pagamentoConfirmado;
    }

    public void setPagamentoConfirmado(boolean pagamentoConfirmado) {
        this.pagamentoConfirmado = pagamentoConfirmado;
    }

    private boolean confirmarPagamento() {
        Date dataAtual = new Date();
        if(dataAtual.before(dataVencimentoReserva)){ //se for anterior
            pagamentoConfirmado = true;
            System.out.println("Pagamento confirmado!");
        }else{
            System.out.println("Pagamento não pode ser realizado. Reserva vencida!");
        }
        return false;
    }

    public boolean testarConfirmarPedido(){
        return confirmarPagamento();
    }

}
