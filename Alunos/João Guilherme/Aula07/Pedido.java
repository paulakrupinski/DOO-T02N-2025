import java.time.LocalDate;
import java.util.List;

public class Pedido {
    public int id;
    public LocalDate dataCriacao;
    public LocalDate dataPagamento;
    public LocalDate dataVencimentoReserva;
    public Cliente cliente;
    public Vendedor vendedor;
    public String loja;
    public List<Item> itens;

    public Pedido(int id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em " + dataCriacao + " | Valor total: R$" + calcularValorTotal());
    }

    public LocalDate getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}