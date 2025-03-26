import java.time.LocalDate;

public class Venda {

    private int quantidade;
    private double valor;
    private double desconto;
    private int idDesconto;
    private LocalDate data;
    private int mes;
    private int dia;
    private static int[][] vendasPorDia = new int[12][30];

    public Venda(){

    }

    public Venda(int quantidade, double valor, double desconto, int mes, int dia) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
        this.data = LocalDate.now(); // Definir a data com a data atual
        this.mes = mes; // Agora, o mês é passado diretamente
        this.dia = dia; // O dia também é passado diretamente
    }

    public int getIdDesconto() {
        return idDesconto;
    }

    public void setIdDesconto(int idDesconto) {
        this.idDesconto = idDesconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void incrementaDesconto(){
        this.idDesconto++;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
        this.mes = data.getMonthValue(); // Atualiza o mês automaticamente
        this.dia = data.getDayOfMonth(); // Atualiza o dia automaticamente
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return "Histórico de venda: " +
                "Quantidade = " + quantidade +
                "| Valor = " + valor +
                "| Desconto = " + desconto +
                "| ID = " + idDesconto;
    }
}
