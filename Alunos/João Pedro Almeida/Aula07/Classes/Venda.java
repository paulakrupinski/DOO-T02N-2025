package Classes;

public class Venda {
    public int quantidade;
    public double precoUnitario;
    public double valorTotal;
    public double desconto;
    public int dia;
    public int mes;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, int dia, int mes) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.dia = dia;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Data: " + dia + "/" + mes + " - Quantidade: " + quantidade + 
               ", Preço Unitário: R$ " + precoUnitario + ", Valor Total: R$ " + 
               valorTotal + ", Desconto: R$ " + desconto;
    }
}