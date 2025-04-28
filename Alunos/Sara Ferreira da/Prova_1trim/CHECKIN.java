public class CHECKIN{
    public void checkIn(Cliente cliente, Quarto quarto) {
        quarto.setOcupado(true);
    }

    public double checkOut(Cliente cliente, Quarto quarto, int diasHospedado) {
        quarto.setOcupado(false);
        return diasHospedado * quarto.getPrecoDiaria();
    }
}

