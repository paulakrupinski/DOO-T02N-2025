public class MAIN {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Quarto> quartos = new ArrayList<>();
    private static ReservaService reservaService = new ReservaService();

    public static void main(String[] args) {
        inicializarQuartos(); // adiciona quartos simples e duplos

        while (true) {
            System.out.println("ESCOLHA UMA OPÇÃO!");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Reservar Quarto");
            System.out.println("4. Realizar Check-in");
            System.out.println("5. Realizar Check-out");
            System.out.println("6. Verificar Disponibilidade");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarQuarto();
                case 3 -> reservarQuarto();
                case 4 -> realizarCheckIn();
                case 5 -> realizarCheckOut();
                case 6 -> verificarDisponibilidade();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarQuarto() {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo (simples/duplo): ");
        String tipo = scanner.nextLine().toLowerCase();

        if (tipo.equals("simples")) {
            quartos.add(new QuartoSimples(numero));
        } else if (tipo.equals("duplo")) {
            quartos.add(new QuartoDuplo(numero));
        } else {
            System.out.println("Tipo inválido.");
            return;
        }
        System.out.println("Quarto cadastrado com sucesso!");
    }

    private static void reservarQuarto() {
        Cliente cliente = escolherCliente();
        Quarto quarto = escolherQuartoDisponivel();
        if (cliente != null && quarto != null) {
            if (reservaService.reservar(cliente, quarto)) {
                System.out.println("Reserva realizada!");
            } else {
                System.out.println("Falha na reserva.");
            }
        }
    }

    private static void realizarCheckIn() {
        Quarto quarto = escolherQuarto();
        if (quarto != null) {
            quarto.setOcupado(true);
            System.out.println("Check-in realizado!");
        }
    }

    private static void realizarCheckOut() {
        Quarto quarto = escolherQuarto();
        if (quarto != null) {
            System.out.print("Dias hospedado: ");
            int dias = scanner.nextInt();
            double valor = reservaService.checkOut(quarto, dias);
            System.out.println("Check-out realizado. Total a pagar: R$" + valor);
        }
    }

    private static void verificarDisponibilidade() {
        Quarto quarto = escolherQuarto();
        if (quarto != null) {
            if (quarto.isDisponivel()) {
                System.out.println("Quarto disponível.");
            } else {
                System.out.println("Quarto ocupado.");
            }
        }
    }

    private static Cliente escolherCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return null;
        }

        System.out.println("Selecione o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        return clientes.get(index);
    }

    private static Quarto escolherQuarto() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
            return null;
        }

        System.out.println("Selecione o quarto:");
        for (int i = 0; i < quartos.size(); i++) {
            System.out.println(i + " - Quarto " + quartos.get(i).getNumero());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        return quartos.get(index);
    }

    private static Quarto escolherQuartoDisponivel() {
        List<Quarto> disponiveis = quartos.stream()
                .filter(Quarto::isDisponivel)
                .toList();

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum quarto disponível.");
            return null;
        }

        System.out.println("Quartos disponíveis:");
        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println(i + " - Quarto " + disponiveis.get(i).getNumero());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        return disponiveis.get(index);
    }

    private static void inicializarQuartos() {
        quartos.add(new QuartoSimples(101));
        quartos.add(new QuartoDuplo(102));
    }
}