package Alunos.FelipeHeringer.Prova_1trim;

public class Quarto {
    private int numeroQuarto;
    private double valorDiaria;
    private boolean[][] disponibilidade;

    public Quarto(int numeroQuarto, double valorDiaria) {
        this.numeroQuarto = numeroQuarto;
        this.valorDiaria = valorDiaria;
        this.disponibilidade = new boolean[12][30];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; j++) {
                disponibilidade[i][j] = true; // Inicialmente todos os dias estão disponíveis
            }
        }
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public boolean verificarDisponibilidadeDoQuarto(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (int i = mesEntrada - 1; i <= mesSaida - 1; i++) {
            for (int j = (i == mesEntrada - 1 ? diaEntrada - 1 : 0); j < (i == mesSaida - 1 ? diaSaida : 30); j++) {
                if (!disponibilidade[i][j]) {
                    return false; // Se algum dia não estiver disponível, retorna falso
                }
            }
        }
        return true; // Todos os dias estão disponíveis
    }

    public void realizarCheckin(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (int i = mesEntrada - 1; i <= mesSaida - 1; i++) {
            for (int j = (i == mesEntrada - 1 ? diaEntrada - 1 : 0); j < (i == mesSaida - 1 ? diaSaida : 30); j++) {
                disponibilidade[i][j] = false; // Marca os dias como não disponíveis
            }
        }
    }

    public void realizarCheckout(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (int i = mesEntrada - 1; i <= mesSaida - 1; i++) {
            for (int j = (i == mesEntrada - 1 ? diaEntrada - 1 : 0); j < (i == mesSaida - 1 ? diaSaida : 30); j++) {
                disponibilidade[i][j] = true; // Marca os dias como não disponíveis
            }
        }
    }

    public double valorTotalDaEstadia(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        int dias = 0;
        for (int i = mesEntrada - 1; i <= mesSaida - 1; i++) {
            for (int j = (i == mesEntrada - 1 ? diaEntrada - 1 : 0); j < (i == mesSaida - 1 ? diaSaida : 30); j++) {
                dias++;
            }
        }
        return dias * valorDiaria;
    }

}
