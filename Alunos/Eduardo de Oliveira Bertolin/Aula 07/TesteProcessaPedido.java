package calculadoraplantas;
import java.util.Date;
import java.util.Calendar;

public class TesteProcessaPedido {
    public static void main(String[] args) {
        // Criar dados simulados
        Cliente cliente = new Cliente();
        cliente.nome = "Lucas";
        cliente.idade = 20;

        Vendedor vendedor = new Vendedor();
        vendedor.nome = "Marina";
        vendedor.idade = 25;
        vendedor.loja = "My Plant";

        Loja loja = new Loja();
        loja.nomeFantasia = "My Plant";
        loja.cnpj = "1234567890001";

        Endereco endereco = new Endereco();
        endereco.rua = "Av. das Flores";
        endereco.numero = "123";
        endereco.bairro = "Centro";
        endereco.cidade = "Cascavel";
        endereco.complemento = "Sala 5";
        cliente.endereco = endereco;
        vendedor.endereco = endereco;
        loja.endereco = endereco;

        Item[] itens = new Item[2];
        itens[0] = new Item();
        itens[0].id = 1;
        itens[0].nome = "Planta 1";
        itens[0].tipo = "Ornamental";
        itens[0].valor = 30;

        itens[1] = new Item();
        itens[1].id = 2;
        itens[1].nome = "Planta 2";
        itens[1].tipo = "Ornamental";
        itens[1].valor = 45;

        // Criando a data de vencimento para AMANHÃ
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DATE, 1);
        Date vencimento = calendario.getTime();

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(1, new Date(), vencimento, cliente, vendedor, loja, itens);

        pedido.gerarDescricaoVenda();
    }

}
