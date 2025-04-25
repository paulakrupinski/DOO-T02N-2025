package sistemahotel;

public class SistemaHotel {
    public static void main(String[] args) {
        Endereco enderecoCliente = new Endereco("São Paulo", "Centro", "Rua das Flores", "123", "Apto 45");
        
        Cliente cliente = new Cliente("João Silva", "123.456.789-00", "(11) 98765-4321", "joao@email.com", 
                                      "01/01/1990", enderecoCliente, "simples", "01/06/2025", "05/06/2025", 4);
        
        cliente.exibirDados();
        
        Quarto quartoSimples = new Quarto(101, "simples", 2, true);
        Quarto quartoDuplo = new Quarto(102, "duplo", 4, true);
        
        Reserva reservaSimples = new Reserva(cliente, quartoSimples, "01/06/2025", "05/06/2025", quartoSimples.getValorDiaria());
        Reserva reservaDuplo = new Reserva(cliente, quartoDuplo, "01/06/2025", "05/06/2025", quartoDuplo.getValorDiaria());
        
        cliente.realizarCheckIn();
        
        System.out.println("Total a pagar pela reserva do quarto simples:");
        reservaSimples.getTotal();
        
        cliente.realizarCheckOut();

        System.out.println("\nVerificando disponibilidade de quarto simples:");
        if(quartoSimples.isDisponivel()) {
            System.out.println("Quarto simples está disponível.");
        } else {
            System.out.println("Quarto simples não está disponível.");
        }

        System.out.println("\nVerificando disponibilidade de quarto duplo:");
        if(quartoDuplo.isDisponivel()) {
            System.out.println("Quarto duplo está disponível.");
        } else {
            System.out.println("Quarto duplo não está disponível.");
        }
    }
}
