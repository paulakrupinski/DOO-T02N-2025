package classes;

import classes.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Quartos {

    public static Quartos quarto = new Quartos(0,null, 0, null, null, true, null);
    public static Cliente cliente = new Cliente(null, null,0,0, null);
    public static  List<Quartos> listaQuartos = new ArrayList<>();


    private int numero;
    private String tipo;
    private double preco;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean disponibilidade;
    private List<Cliente>hospedesQuarto;

    public Quartos(int numero, String tipo, double preco, LocalDate checkIn, LocalDate checkOut, boolean disponibilidade, List<Cliente> hospedesQuarto) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.disponibilidade = disponibilidade;
        this.hospedesQuarto = hospedesQuarto;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<Cliente> getHospedesQuarto() {
        return hospedesQuarto;
    }

    public void setHospedesQuarto(List<Cliente> hospedesQuarto) {
        this.hospedesQuarto = hospedesQuarto;
    }

    public static void cadastroQuartos(Quartos quarto, Cliente cliente){

        Scanner scan = new Scanner(System.in);

        int comparacao = 0;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Cliente> hospedesQuarto = new ArrayList<>();

        //Quartos quarto = new Quartos(0,null, 0, null, null, true, null);

        System.out.println("Numero do quarto:");
        quarto.setNumero(scan.nextInt());
        System.out.println("Tipo:\n1-Simples \n2-Duplo");
        int opcao = scan.nextInt();

        if(opcao == 1){

            quarto.setTipo("simples");

        } else if (opcao == 2){

            quarto.setTipo("duplo");

        }else{

            System.out.println("opcao invalida");

        }

        if(quarto.getTipo().equalsIgnoreCase("duplo")){

            quarto.setPreco(500);

        }else{

            quarto.setPreco(250);

        }
        System.out.println("Check-in:");
        String dataCheckIn = scan.nextLine();
        LocalDate data01 = LocalDate.parse(dataCheckIn, formato);
        System.out.println("Check-out:");
        String dataCheckOut = scan.nextLine();
        LocalDate data02 = LocalDate.parse(dataCheckOut, formato);

        boolean menu = true;

        while(menu) {
            System.out.println("Quantos hospedes ficaram no quarto?");
            int numeroHospedes = scan.nextInt();
            comparacao = numeroHospedes;

            if (quarto.getTipo().equalsIgnoreCase("duplo") && numeroHospedes > 4) {

                System.out.println("Numero maximo de hospedes em um quarto excedido.\nCadastro nao autorizado");

            } else if (quarto.getTipo().equalsIgnoreCase("simples") && numeroHospedes > 2) {

                System.out.println("Numero maximo de hospedes em um quarto excedido.\nCadastro nao autorizado");

            }
        }

        for (int i = 0; i<= comparacao; i++) {
            System.out.println("Nome cliente:");
            cliente.setNome(scan.nextLine());
            System.out.println("CPF:");
            cliente.setCpf(scan.nextLine());
            System.out.println("Idade:");
            cliente.setIdade(scan.nextInt());
            System.out.println("Id:");
            cliente.setId(scan.nextInt());

            hospedesQuarto.add(cliente);
        }

        listaQuartos.add(quarto);

    }

    public static void checkIn(Quartos quarto, Cliente cliente){

        Scanner scan = new Scanner(System.in);


        System.out.println("Informe o numero do quarto ");
        int numero01 = scan.nextInt();

        for(Quartos q : listaQuartos){

            if(q.getCheckIn().isAfter(LocalDate.now())){

                System.out.println("data de check-in ultrapassada\ncheck-in impossibilitado");

            }else{

                System.out.println("check-in realizado");

                q.setDisponibilidade(false);

            }

        }



    }

    public static void checkOut(Quartos quarto, Cliente cliente){

        Scanner scan = new Scanner(System.in);


        System.out.println("Informe o numero do quarto ");
        int numero02 = scan.nextInt();

        for(Quartos q : listaQuartos){

            if(q.getCheckOut().isAfter(LocalDate.now())){

                System.out.println("data de check-out ultrapassada\nmulta de R$20,00 por dia de reserva");
                double multa = q.getPreco();

                multa = multa + 20;

                q.setPreco(multa);

            }else{

                System.out.println("check-out realizado");

                q.setDisponibilidade(true);


            }

        }

    }

    public static void calcularDiarias(Quartos quarto, Cliente cliente){

       long totalDiarias = ChronoUnit.DAYS.between(quarto.getCheckIn(), quarto.getCheckOut());

       double totalPagar = quarto.getPreco() * totalDiarias;

        System.out.println("O total a ser pago é R$" + totalPagar);
    }

    public static void verificarDisponibilidade(Quartos quarto, Cliente cliente){

        Scanner scan = new Scanner(System.in);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("qual o numero do quarto");
        int numeroComparacao = scan.nextInt();
        System.out.println("data de inicial");
        String dataInicial = scan.nextLine();
        LocalDate data01 = LocalDate.parse(dataInicial, formato);
        System.out.println("data final");
        String dataFinal = scan.nextLine();
        LocalDate data02 = LocalDate.parse(dataFinal, formato);

        for(Quartos q : listaQuartos){

            if(q.getCheckIn().isBefore(data01) || q.checkIn.isAfter(data01) || q.checkIn.isAfter(data02) && q.checkOut.isBefore(data01) || q.checkOut.isAfter(data02)){


                System.out.println("Quarto disponivel");



            }else{

                System.out.println("Quarto indisponivel");

            }


        }


    }

    @Override
    public String toString() {
        return "Quartos{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", disponibilidade=" + disponibilidade +
                ", hospedesQuarto=" + hospedesQuarto +
                '}';
    }
}


