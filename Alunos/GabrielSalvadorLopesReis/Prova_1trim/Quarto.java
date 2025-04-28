package Prova_1trim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quarto {
    private Integer id;
    private int tipo;
    private Double valor;
    private List<Reserva> reservas = new ArrayList<Reserva>();

    static private List<Quarto> quartos = new ArrayList<Quarto>();
    static private Integer proximoId = 0;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Quarto(Integer tipo, Double valor) {
        this.id = proximoId++;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Quarto() {

    }

    public static void adicionarQuarto() {
        int tipo = 0;
        Double valor;

        System.out.println("Tipo do quarto: [1]Simples [2]Duplo");
        tipo = Menu.sc.nextInt();
        Menu.sc.nextLine();

        System.out.println("Valor da diária:");
        valor = Menu.sc.nextDouble();
        Menu.sc.nextLine();

        Quarto quarto = new Quarto(tipo, valor);
        quartos.add(quarto);
    }

    public static void listarQuartos() {
        System.out.println("Quartos");
        for (Quarto quarto : quartos) {
            System.out.println(quarto.toString());
        }
    }

    public static Quarto capturarQuarto(Integer id) {
        for (Quarto quarto : quartos) {
            if (Objects.equals(id, quarto.id)) {
                return quarto;
            }
        }
        return null;
    }

    public static String verificarDisponiblidade() {
        String data;
        Quarto quarto;
        listarQuartos();
        System.out.println("Selecione o quarto:");

        quarto = capturarQuarto(Menu.sc.nextInt());
        Menu.sc.nextLine();

        System.out.println("Data de checkin [dd/MM/yyyy]");
        data = Menu.sc.nextLine();
        LocalDate dataInicio = LocalDate.parse(data, formatter);

        System.out.println("Data de checkout [dd/MM/yyyy]");
        data = Menu.sc.nextLine();
        LocalDate dataFim = LocalDate.parse(data, formatter);


        assert quarto != null;
        for (Reserva reserva : quarto.reservas) {
            if (reserva.conflitaCom(dataInicio, dataFim)) {
                return "Indisponível";
            }
        }
        return "Disopnível";
    }

    public boolean verificarDisponiblidade(Quarto quarto, LocalDate dataInicio, LocalDate dataFim) {
        assert quarto != null;
        for (Reserva reserva : quarto.reservas) {
            if (reserva.conflitaCom(dataInicio, dataFim)) {
                return false;
            }
        }
        return true;
    }

    public static void novaReserva() {
        Cliente hospede;
        Quarto quarto;
        Reserva reserva = new Reserva();
        String data;

        System.out.println("Cliente: ");
        Cliente.listarClientes();
        System.out.println("Selecione o cliente: [id]");
        hospede = Cliente.capturarCliente(Menu.sc.nextInt());

        System.out.println("Quarto: ");
        listarQuartos();
        System.out.println("Selecione o quarto: [id]");
        quarto = Quarto.capturarQuarto(Menu.sc.nextInt());
        Menu.sc.nextLine();
        System.out.println("Data de checkin [dd/MM/yyyy]");
        data = Menu.sc.nextLine();
        LocalDate dataInicio = LocalDate.parse(data, formatter);

        System.out.println("Data de checkout [dd/MM/yyyy]");
        data = Menu.sc.nextLine();
        LocalDate dataFim = LocalDate.parse(data, formatter);

        reserva.adcionarReserva(dataInicio, dataFim, hospede);

        quarto.reservas.add(reserva);
    }

    private String intToString(int i) {
        if (i == 1) {
            return "Simples";
        } else {
            return "Duplo";
        }
    }

    @Override
    public String toString() {
        return "id: " + id + " | tipo: " + intToString(this.tipo) + " | diária: " + valor;
    }

}
