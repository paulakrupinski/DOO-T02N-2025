package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class reserva {
    private cliente cliente;
    private quarto quarto;
    private LocalDate dataentrada;
    private LocalDate datasaida;
    private boolean checkinrealizado;
    private boolean checkoutrealizado;

    public reserva(cliente cliente, quarto quarto, LocalDate entrada, LocalDate saida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataentrada = entrada;
        this.datasaida = saida;
    }

    public void realizarcheckin() {
        this.checkinrealizado = true;
    }

    public void realizarcheckout() {
        this.checkoutrealizado = true;
    }

    public double calculartotal() {
        long dias = ChronoUnit.DAYS.between(dataentrada, datasaida);
        return dias * quarto.getPrecoDiaria();
    }

    public boolean estadisponivel(LocalDate data) {
        return data.isBefore(dataentrada) || data.isAfter(datasaida);
    }

    public quarto getquarto() {
        return quarto;
    }

    public LocalDate getdataentrada() {
        return dataentrada;
    }

    public LocalDate getdatasaida() {
        return datasaida;
    }

    public cliente getcliente() {
        return cliente;
    }

    public boolean ischeckinrealizado() {
        return checkinrealizado;
    }

    public boolean ischeckoutrealizado() {
        return checkoutrealizado;
    }
