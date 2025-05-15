import java.time.LocalDate;

public class Reserva {
    private String nomeHospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private String tipoDeQuarto;
    private String numeroQuarto;

    public Reserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, String tipoDeQuarto, String numeroQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.tipoDeQuarto = tipoDeQuarto;
        this.numeroQuarto = numeroQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public String getTipoDeQuarto() {
        return tipoDeQuarto;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void detalheReserva() {
        System.out.println("Hóspede: " + nomeHospede + " | Check-in: " + dataCheckIn + " | Tipo do quarto: " + tipoDeQuarto + " | Número do quarto: " + numeroQuarto);
    }
}
