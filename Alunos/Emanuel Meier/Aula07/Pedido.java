package fag.objeto;

import java.util.Date;
import java.util.List;

public class Pedido {
	private int id;
	private Date dataCriacao, dataPagamento, dataVencimentoReserva;
	private Cliente cliente;
	private Vendedor vendedor;
	private String loja;
	private List<Item> itens;
	
	public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente,
			Vendedor vendedor, String loja, List<Item> itens) {
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
		double total = 0.0;
		for (Item item : itens) {
			total += item.getValor();
		}
		return total;
	}
	
	public void gerarDescricaoVenda() {
		System.out.println("Pedido criado em " + dataCriacao + " | Valor total: R$ " + String.format("%.2f", calcularValorTotal()));
	}
	
	public Date getDataVencimentoReserva() {
		return dataVencimentoReserva;
	}
	
	public List<Item> getItens() {
	    return itens;
	}
}
