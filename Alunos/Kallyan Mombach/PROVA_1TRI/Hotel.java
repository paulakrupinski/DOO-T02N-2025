
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel(){
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto){
            quartos.add(quarto); 
        }

    public void listarQuartos(){
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public boolean verificarDisponibilidade(Quarto quarto, int dataIn, int dataOut) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto) &&
                !(dataOut <= reserva.getDataIn() || dataIn >= reserva.getDataOut())) {
                return false;  
            }
        }
        return true;  
    }

    public void realizarCheckIn(Cliente cliente, Quarto quarto, int dataIn, int dataOut) {
        if (!verificarDisponibilidade(quarto, dataIn, dataOut)) {
            System.out.println("O quarto " + quarto.getNum() + " não está disponível para as datas solicitadas.");
        } else {
            quarto.setOcupado(true);
            Reserva reserva = new Reserva(quarto, cliente, dataIn, dataOut, null);
            reservas.add(reserva);
            System.out.println("Check-in realizado com sucesso!");
            System.out.println(reserva);
        }
    }   

    public void realizarCheckOut(Quarto quarto){
        if (quarto.isOcupado()) {
            quarto.setOcupado(false);
            System.out.println("Check Out realizado com sucesso!");
        }
    }

    public void listarReservas(){
      for (Reserva reserva : reservas) {
        System.out.println(reserva);
      }
    }

    }

