public class Quartos {
    private String tipoDeQuarto;
    private String numeroQuarto;
    private String valorQuarto;
    private boolean disponibilidade;

    public Quartos(String tipoDeQuarto, String numeroQuarto, String valorQuarto) {
        this.tipoDeQuarto = tipoDeQuarto;
        this.numeroQuarto = numeroQuarto;
        this.valorQuarto = valorQuarto;
        this.disponibilidade = false;
    }

    public String getTipoDeQuarto() {
        return tipoDeQuarto;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getValorQuarto() {
        return valorQuarto;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
