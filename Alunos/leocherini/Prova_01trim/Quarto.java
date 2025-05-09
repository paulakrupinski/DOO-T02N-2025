package provaBum;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

abstract class Quarto {
    protected int numero;
    protected double preco;
    protected Map<LocalDate, Integer> reservas;

    public Quarto(int numero, double preco) {
        this.numero = numero;
        this.preco = preco;
        this.reservas = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return !reservas.isEmpty();
    }

    public void reservar(LocalDate entrada, LocalDate saida, int pessoas) {
        for (LocalDate d = entrada; !d.isAfter(saida); d = d.plusDays(1)) {
            reservas.put(d, reservas.getOrDefault(d, 0) + pessoas);
        }
    }

    public void liberar(LocalDate entrada, LocalDate saida) {
        for (LocalDate d = entrada; !d.isAfter(saida); d = d.plusDays(1)) {
            reservas.remove(d);
        }
    }

    public double getPreco() {
        return preco;
    }

    public boolean isReservadoPara(LocalDate data) {
        return reservas.containsKey(data);
    }

    public int getReservasPara(LocalDate data) {
        return reservas.getOrDefault(data, 0);
    }

    public abstract boolean capacidadeExcedida(int pessoas);

    @Override
    public String toString() {
        return "Quarto " + numero + " | Ocupado: " + (isOcupado() ? "Sim" : "Não") + " | Preço: R$" + preco;
    }


}