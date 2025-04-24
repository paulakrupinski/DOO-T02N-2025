import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SistemaHospedagem {

    static class RegistroHospede {
        String identificador;
        String nomeCompleto;

        RegistroHospede(String nome, String cpf) {
            this.nomeCompleto = nome;
            this.identificador = cpf;
        }

        @Override
        public String toString() {
            return nomeCompleto + " | CPF: " + identificador;
        }
    }

    abstract static class UnidadeEstadia {
        int codigo;
        double diaria;
        boolean ocupado;

        UnidadeEstadia(int codigo, double diaria) {
            this.codigo = codigo;
            this.diaria = diaria;
            this.ocupado = false;
        }

        abstract int capacidadeMaxima();

        boolean estaLivre() {
            return !ocupado;
        }

        @Override
        public String toString() {
            return "Unidade " + codigo + " | Capacidade: " + capacidadeMaxima() + " | R$" + diaria + "/dia | " + (ocupado ? "Em uso" : "Disponível");
        }
    }

    static class SuiteSimples extends UnidadeEstadia {
        SuiteSimples(int codigo) {
            super(codigo, 120.0);
        }

        @Override
        int capacidadeMaxima() {
            return 2;
        }
    }

    static class SuiteExecutiva extends UnidadeEstadia {
        SuiteExecutiva(int codigo) {
            super(codigo, 200.0);
        }

        @Override
        int capacidadeMaxima() {
            return 4;
        }
    }

    static class RegistroReserva {
        RegistroHospede hospede;
        UnidadeEstadia unidade;
        LocalDate dataEntrada;
        LocalDate dataSaida;

        RegistroReserva(RegistroHospede hospede, UnidadeEstadia unidade, LocalDate entrada, LocalDate saida) {
            this.hospede = hospede;
            this.unidade = unidade;
            this.dataEntrada = entrada;
            this.dataSaida = saida;
        }

        double calcularTotal() {
            long dias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
            return dias * unidade.diaria;
        }

        @Override
        public String toString() {
            return hospede + " → " + unidade + " | De " + dataEntrada + " até " + dataSaida;
        }
    }

    static List<RegistroHospede> listaHospedes = new ArrayList<>();
    static List<UnidadeEstadia> listaQuartos = new ArrayList<>();
    static List<RegistroReserva> historicoReservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Hospedagem ---");
            System.out.println("1. Novo Hóspede");
            System.out.println("2. Novo Quarto");
            System.out.println("3. Criar Reserva");
            System.out.println("4. Check-In");
            System.out.println("5. Check-Out");
            System.out.println("6. Consultar Quartos");
            System.out.println("0. Finalizar");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> registrarHospede(entrada);
                case 2 -> adicionarQuarto(entrada);
                case 3 -> registrarReserva(entrada);
                case 4 -> realizarCheckIn(entrada);
                case 5 -> realizarCheckOut(entrada);
                case 6 -> listarQuartos();
            }
        } while (opcao != 0);

        System.out.println("Encerrando sistema.");
    }

    static void registrarHospede(Scanner sc) {
        System.out.print("Nome completo: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        listaHospedes.add(new RegistroHospede(nome, cpf));
        System.out.println("Hóspede adicionado com sucesso.");
    }

    static void adicionarQuarto(Scanner sc) {
        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Tipo (1 - Simples | 2 - Executiva): ");
        int tipo = sc.nextInt();
        sc.nextLine();
        UnidadeEstadia quarto = (tipo == 1) ? new SuiteSimples(numero) : new SuiteExecutiva(numero);
        listaQuartos.add(quarto);
        System.out.println("Quarto registrado.");
    }

    static void registrarReserva(Scanner sc) {
        RegistroHospede hospede = selecionarHospede(sc);
        UnidadeEstadia quarto = selecionarQuarto(sc);

        if (!quarto.estaLivre()) {
            System.out.println("Quarto indisponível.");
            return;
        }

        System.out.print("Data de entrada (AAAA-MM-DD): ");
        LocalDate entrada = LocalDate.parse(sc.nextLine());
        System.out.print("Data de saída (AAAA-MM-DD): ");
        LocalDate saida = LocalDate.parse(sc.nextLine());

        RegistroReserva reserva = new RegistroReserva(hospede, quarto, entrada, saida);
        historicoReservas.add(reserva);
        quarto.ocupado = true;
        System.out.println("Reserva confirmada. Valor: R$" + reserva.calcularTotal());
    }

    static void realizarCheckIn(Scanner sc) {
        RegistroReserva r = escolherReserva(sc);
        if (r != null) {
            r.unidade.ocupado = true;
            System.out.println("Check-in realizado.");
        }
    }

    static void realizarCheckOut(Scanner sc) {
        RegistroReserva r = escolherReserva(sc);
        if (r != null) {
            r.unidade.ocupado = false;
            System.out.println("Check-out concluído. Total: R$" + r.calcularTotal());
        }
    }

    static void listarQuartos() {
        listaQuartos.forEach(System.out::println);
    }

    static RegistroHospede selecionarHospede(Scanner sc) {
        for (int i = 0; i < listaHospedes.size(); i++) {
            System.out.println((i + 1) + ". " + listaHospedes.get(i));
        }
        System.out.print("Escolha o hóspede: ");
        return listaHospedes.get(sc.nextInt() - 1);
    }

    static UnidadeEstadia selecionarQuarto(Scanner sc) {
        for (int i = 0; i < listaQuartos.size(); i++) {
            System.out.println((i + 1) + ". " + listaQuartos.get(i));
        }
        System.out.print("Escolha o quarto: ");
        return listaQuartos.get(sc.nextInt() - 1);
    }

    static RegistroReserva escolherReserva(Scanner sc) {
        for (int i = 0; i < historicoReservas.size(); i++) {
            System.out.println((i + 1) + ". " + historicoReservas.get(i));
        }
        System.out.print("Escolha a reserva: ");
        return historicoReservas.get(sc.nextInt() - 1);
    }
}
