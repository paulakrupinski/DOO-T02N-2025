public class Quarto {
    private String numero;
    private int valorDiaria;

    public Quarto(String numero, int valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
    }

    public Quarto() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
