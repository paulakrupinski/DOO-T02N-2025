
public class Hotel {
    Cliente cliente;
    Quarto quarto;
    Reserva reserva;
// Cliente
    public void cadastrarCliente(String nome) {
        cliente = new Cliente(nome);
        System.out.println("Seja Bem Vindo, Obrigado por se Cadastrar: " + nome);
    }
//Quarto
    public void cadastrarQuarto(int numero, String tipo) {
        if (tipo.equalsIgnoreCase("simples")) {
            quarto = new QuartoSimples(numero);
        } else if (tipo.equalsIgnoreCase("duplo")) {
            quarto = new QuartoDuplo(numero);
        } else {
            System.out.println("Este Quarto nao Esta Disponivel/invalido.");
            return;
        }

        System.out.println("Quarto " + tipo + " numero " + numero + " cadastrado.");
    }
//reserva
    public void reservarQuarto(int dias) {
        if (cliente == null || quarto == null) {
            System.out.println("Antes que possa usar esta opcao e preciso cadastrar cliente e quarto primeiro.");
            return;
        }

        if (quarto.isOcupado()) {
            System.out.println("Este quarto já esta ocupado.");
            return;
        }

        reserva = new Reserva(cliente, quarto, dias);
        quarto.ocupar();
        System.out.println("Reserva feita para " + cliente.nome + " por " + dias + " dias.");
    }
//checkout
    public void realizarCheckOut() {
        if (reserva == null) {
            System.out.println("Nenhuma rerva foi encontrada.");
            return;
        }

        double total = reserva.calcularTotal();
        reserva.quarto.liberar();
        System.out.println("Check-out realizado. O total a pagar: R$ " + total);
        reserva = null;
    }
//ver se tem quarto
    public void verificarDisponibilidade() {
        if (quarto == null) {
            System.out.println("Nenhum quarto foi cadastrado.");
        } else if (quarto.isOcupado()) {
            System.out.println("Quarto numero " + quarto.numero + " esta ocupado.");
        } else {
            System.out.println("Quarto numero " + quarto.numero + " esta disponivel.");
        }
    }
}
