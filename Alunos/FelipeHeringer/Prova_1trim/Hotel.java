package Alunos.FelipeHeringer.Prova_1trim;

import java.util.ArrayList;

public class Hotel {
    private String nomeHotel;
    private ArrayList<Quarto> quartos;
    private ArrayList<Cliente> clientes;

    public Hotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
        this.quartos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean verificarDisponibilidade(int numeroQuarto, int diaEntrada, int mesEntrada, int diaSaida,
            int mesSaida) {
        boolean QuartoEstaDisponivel = false;
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto) {
                QuartoEstaDisponivel = quarto.verificarDisponibilidadeDoQuarto(diaEntrada, mesEntrada, diaSaida,
                        mesSaida);
                break;
            }
        }
        return QuartoEstaDisponivel;
    }

    public void realizarCheckin(int numeroQuarto, int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto) {
                quarto.realizarCheckin(diaEntrada, mesEntrada, diaSaida, mesSaida);
                break;
            }
        }
    }

    public void realizarCheckout(int numeroQuarto, int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto) {
                quarto.realizarCheckout(diaEntrada, mesEntrada, diaSaida, mesSaida);
                break;
            }
        }
    }

    public void valorTotalDaEstadia(int numeroQuarto, int diaEntrada, int mesEntrada, int diaSaida, int mesSaida) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numeroQuarto) {
                double valorTotal = quarto.valorTotalDaEstadia(diaEntrada, mesEntrada, diaSaida, mesSaida);
                System.out.println("Valor total da estadia: " + valorTotal);
                break;
            }
        }
    }

    public String getNomeHotel() {
        return nomeHotel;
    }
}
