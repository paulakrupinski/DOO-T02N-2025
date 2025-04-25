import java.text.SimpleDateFormat;
import java.util.Date;

public class VendaUpgrade2 {

    private int id;
    private int qtd;
    private double valor;
    private double desconto;
    private String data;

    private static int novoId = 0;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
    Date dataAtual = new Date();

    public VendaUpgrade2(int qtd, double valor, double desconto) {
        this.id = ++novoId;
        this.qtd = qtd;
        this.valor = valor;
        this.desconto = desconto;
        this.data = sdf.format(dataAtual);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id: " + id +
                " | valor: " + valor +
                " | quantidade: " + qtd +
                " | desconto:" + desconto +
                " | data: " + data +
                '}';
    }
}
