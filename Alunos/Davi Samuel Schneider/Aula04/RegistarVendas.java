import java.time.LocalDate;

public class RegistarVendas {
    private LocalDate localDate;
    private int quantidade;


    public static void buscarVendas() {
        System.out.println();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
