import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Logica {

    static List<Cliente> listaDeCliente = new ArrayList<>();
    static List<Quarto> listaDeQuarto = new ArrayList<>();

    public static void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Nome: ");
        cliente.setNome(App.scan.nextLine());

        System.out.println("Idade: ");
        cliente.setIdade(App.scan.nextInt());
        App.scan.nextLine();

        listaDeCliente.add(cliente);
        System.out.println(cliente);
    }

    public static void cadastrarQuarto(){
        Quarto quarto = new Quarto();
        System.out.println("Tipo: [1] Simples (50 reais) / [2] Duplo (100 reais)");
        quarto.setTipo(App.scan.nextInt());
        App.scan.nextLine();

        System.out.println("Nome: ");
        quarto.setNome(App.scan.nextLine());

        boolean valorValido = false;

        //código morre aqui
        while(!valorValido){
            System.out.println("Valor: ");
            int valor = App.scan.nextInt();
            App.scan.nextLine();
            if(quarto.getTipo() == 1 && valor > 50){
                System.out.println("Valor incorreto. O valor tem que ser a cima de 50");
            }else if((quarto.getTipo() == 2 && valor < 100)){
                System.out.println("Valor incorreto. O valor tem que ser a cima de 50");
            }else{
                quarto.setValor(valor);
                valorValido = true;
            }
        }

        quarto.setId(quarto.proximoId);
        listaDeQuarto.add(quarto);


    }

    public static void reservaDeQuarto(){
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();

        System.out.println(cliente);
        System.out.println(quarto);

        System.out.println("Nome da pessoa: ");
        String nome = App.scan.nextLine();

        System.out.println("Nome do quarto: ");
        String nomeQuarto = App.scan.nextLine();

        for(Quarto q : listaDeQuarto){
            if(q.getNome().equals(nomeQuarto)){
                if(q.getDisponibilidade() > 0){
                    q.setDisponibilidade(q.getDisponibilidade() - 1);
                    System.out.println("Reserva confirmada para: " + nome);
                }else{
                    System.out.println("Quarto ocupado ou não encontrado");
                }
            }

        }

    }

    public static void realizarCheckin(){
        System.out.println("Lista de quartos: ");

        for(Quarto q : listaDeQuarto){
            System.out.println(q);
        }

        System.out.println("Nome do cliente: ");
        String nomeCliente = App.scan.nextLine();

        System.out.println("Nome do quarto: ");
        String nomeQuarto = App.scan.nextLine();

        Cliente cliente = null;
        for(Cliente c : listaDeCliente){
            if(c.getNome().equals(nomeCliente)){}
            cliente = c;
            break;
        }

        if(nomeCliente == null){
            System.out.println("Cliente não encontrado");
        }

        Quarto quarto = null;
        for(Quarto q : listaDeQuarto){
            if(q.getNome().equals(nomeQuarto)){}
            quarto = q;
            break;
        }

        if(nomeQuarto == null){
            System.out.println("Quarto não encontrado");
        }

        quarto.setDataEntrada(LocalDate.now());
        quarto.checkin(cliente);

    }

    public static void realizarCheckout(){
        System.out.println("Lista de quartos: ");

        for(Quarto q : listaDeQuarto){
            System.out.println(q);
        }

        System.out.println("Nome do cliente: ");
        String nomeCliente = App.scan.nextLine();

        System.out.println("Nome do quarto: ");
        String nomeQuarto = App.scan.nextLine();

        Cliente cliente = null;
        for(Cliente c : listaDeCliente){
            if(c.getNome().equals(nomeCliente)){}
            cliente = c;
            break;
        }

        if(nomeCliente == null){
            System.out.println("Cliente não encontrado");
        }

        Quarto quarto = null;
        for(Quarto q : listaDeQuarto){
            if(q.getNome().equals(nomeQuarto)){}
            quarto = q;
            break;
        }

        if(nomeQuarto == null){
            System.out.println("Quarto não encontrado");
        }

        quarto.setDataSaida(LocalDate.now());
        quarto.checkout();

    }

    //public static void disponibilidadeDeQuartoParaDataEspecifica(){
//        System.out.println("Lista de quartos: ");
//
//        for(Quarto q : listaDeQuarto){
//            System.out.println(q);
//        }
//
//        System.out.println("Entre com uma data: ");
//        LocalDate nome = LocalDate.parse(App.scan.nextLine());
//        for(Quarto q : listaDeQuarto){
//            if(q.get){
//                System.out.println("");
//            }
//        }
//
//    }


}
