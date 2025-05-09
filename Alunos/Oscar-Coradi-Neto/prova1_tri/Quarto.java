package prova1_tri;

class Quarto{

    int codQuarto;
    String tipoQuarto;
    double precoDiaria;
    int hospedesQuarto;
    boolean disponibilidadeQuarto = true;

    public Quarto(int codQuarto, String tipoQuarto, double precoDiaria, int hospedesQuarto, boolean disponibilidadeQuarto) {
        this.codQuarto = codQuarto;
        this.tipoQuarto = tipoQuarto;
        this.precoDiaria = precoDiaria;
        this.hospedesQuarto = hospedesQuarto;
        this.disponibilidadeQuarto = true; // Inicialmente disponível
    }

    // Getters e Setters
    public int getCodQuarto() {
        return codQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public double getPrecoDiarioQuarto() {
        return precoDiaria;
    }

    public boolean isDisponivel() {
        return disponibilidadeQuarto;
    }

    public void setDisponibilidadeQuarto(boolean disponibilidadeQuarto) {
        this.disponibilidadeQuarto = disponibilidadeQuarto;
    }

    @Override
    public String toString() {
        return "Quarto [Número: " + codQuarto + ", Tipo: " + tipoQuarto
                + ", Preço Diário: R$" + precoDiaria + ", Capacidade: " + hospedesQuarto
                + ", Disponível: " + (disponibilidadeQuarto ? "Sim" : "Não") + "]";
    }

}