import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate dataCriacao, dataPagamento;
    LocalDate dataVencimentoReserva;
    private String cliente, vendedor, loja;
    private List<Item> itens;

    public Pedido(int id, LocalDate dataCriacao, LocalDate dataVencimentoReserva, String cliente, String vendedor, String loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(item -> item.valor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor Total: R$" + calcularValorTotal());
    }
}