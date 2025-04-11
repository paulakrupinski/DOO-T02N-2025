import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando endereço da loja
        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Bairro Central", 100, "Próximo ao parque");
        Loja loja = new Loja("My Plant", "My plant LTDA", "00.001.002.0001-22", enderecoLoja);

        // Exibindo dados da loja
        loja.apresentarse();

        // Criando gerente
        Endereco enderecoGerente = new Endereco("SP", "São Paulo", "Bairro Nobre", 505, "Cobertura");
        Gerente gerente = new Gerente("Fernanda", 40, loja, enderecoGerente, 7000.0);
        gerente.apresentarse();

        // Criando vendedores
        Endereco enderecoV1 = new Endereco("SP", "São Paulo", "Bairro Azul", 101, "Apto 5");
        Vendedor vendedor1 = new Vendedor("Carlos", 30, loja, enderecoV1, 3000.0);
        vendedor1.apresentarse();

        Endereco enderecoV2 = new Endereco("SP", "São Paulo", "Bairro Amarelo", 202, "Casa 2");
        Vendedor vendedor2 = new Vendedor("Ana", 25, loja, enderecoV2, 3000.0);
        vendedor2.apresentarse();

        // Criando clientes
        Endereco enderecoC1 = new Endereco("SP", "São Paulo", "Bairro Verde", 303, "Bloco B");
        Cliente cliente1 = new Cliente("Mariana", 28, enderecoC1);
        cliente1.apresentarse();

        Endereco enderecoC2 = new Endereco("SP", "São Paulo", "Bairro Roxo", 404, "Casa 12");
        Cliente cliente2 = new Cliente("João", 35, enderecoC2);
        cliente2.apresentarse();

        // Cálculo de média e bônus
        System.out.println("Média Salarial do Gerente: " + gerente.calcularMedia());
        System.out.println("Bônus do Gerente: " + gerente.calcularBonus());
        System.out.println("Média Salarial do Vendedor 1: " + vendedor1.calcularMedia());
        System.out.println("Bônus do Vendedor 1: " + vendedor1.calcularBonus());

        // Contagem
        System.out.println("======================================");
        System.out.println("Total de vendedores: 2");
        System.out.println("Total de clientes: 2");
        System.out.println("======================================");

        // ====== PROCESSAMENTO DE PEDIDO =======
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Orquídea", "Flor", 25.0));
        itens.add(new Item(2, "Samambaia", "Planta", 40.0));

        Date dataCriacao = new Date(); // agora
        Date dataPagamento = new Date(); // agora
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + (2L * 24 * 60 * 60 * 1000)); // +2 dias

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(1, dataCriacao, dataPagamento, dataVencimentoReserva, cliente1, vendedor1, loja, itens);

        if (pedido != null) {
            pedido.gerarDescricao();
        }
    }
}
