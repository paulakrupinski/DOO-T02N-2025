package Aula07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date date;
    private String cliente;
    private String vendedor;
    private String loja;
    private List<Venda> listaDeItens;
    private Date dataVencimentoReserva;

    public Pedido(){
        listaDeItens = new ArrayList<>();
    }

    public Pedido(int id, Date date, String cliente, String vendedor, String loja, List<Venda> listaDeItens) {
        this.id = id;
        this.date = date;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.listaDeItens = listaDeItens;
    }

    public Pedido(Date vencimentoAmanha) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public List<Venda> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<Venda> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public void incrementaId(){
        this.id++;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", date=" + date +
                ", cliente='" + cliente + '\'' +
                ", vendedor='" + vendedor + '\'' +
                ", loja='" + loja + '\'' +
                ", listaDeItens=" + listaDeItens +
                '}';
    }

    public double calcularValorTotal(){
        double total = 0;
        for(Venda venda : listaDeItens){
            total+= venda.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda(){
        System.out.println("Data de criação: " + this.date);
        System.out.println("Valor total: R$" + calcularValorTotal());
    }

}
