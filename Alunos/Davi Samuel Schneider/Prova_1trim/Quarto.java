public abstract class Quarto {
    private String numQuarto;
    private double valorDiaria;
    private boolean isDisponivel;

    public Quarto(String numQuarto, double valorDiaria) {
        this.numQuarto = numQuarto;
        this.valorDiaria = valorDiaria;
        this.isDisponivel = true;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
