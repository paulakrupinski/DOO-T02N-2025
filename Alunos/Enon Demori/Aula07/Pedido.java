package aula2;

import java.util.Date;

public class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    Item[] itens;

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + " | Valor total: R$" + calcularValorTotal());
    }
    private boolean confirmarPagamento() {
        Date dataAtual = new Date(); 
        return !dataAtual.after(dataVencimentoReserva); 
    }
    public void testarConfirmacaoPagamento() {
        boolean confirmado = confirmarPagamento();
        if (confirmado) {
            System.out.println("Pagamento confirmado dentro do prazo.");
        } else {
            System.out.println("Pagamento NÃO confirmado. Prazo vencido.");
        }
    }

}
