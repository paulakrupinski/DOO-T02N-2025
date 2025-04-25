public class Venda {

    private int quantidade;
    private double valor;
    private double desconto;
    private int idDesconto;

    public Venda(){

    }

    public Venda(int quantidade, double valor, double desconto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
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

    public void incrementaDisconto(){
        this.idDesconto++;
    }


    @Override
    public String toString() {
        return "Hisrtórtico de venda: " +
                "Quantidade = " + quantidade +
                "| Valor = " + valor +
                "|  Desconto = " + desconto +
                "| id = " + idDesconto;
    }
}
