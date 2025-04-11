package Alunos.FelipeHeringer.Aula07;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Alunos.FelipeHeringer.Aula07.funcionarios.Vendedor;

public class Menu {
    private Scanner scanner;
    private ArrayList<Loja> lojas = new ArrayList<>();
    
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void menuPrincipal(){
        System.out.println("--- Menu Principal ---");
        System.out.println("1. Cadastrar Loja");
        System.out.println("2. Visualizar Lojas ");
        System.out.println("3. Ir para o Menu da Loja");
        System.out.println("0. Sair");
        System.out.println("=========================");
        Integer opcao = this.scanner.nextInt();
        this.scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                Loja loja = new Loja();
                Endereco endereco = new Endereco();
                System.out.println("Informe o nome da loja: ");
                String nome = this.scanner.nextLine();
                loja.setNomeFantasia(nome);
                System.out.println("Informe o CNPJ da Loja: ");
                String cnpj = this.scanner.nextLine();
                loja.setCnpj(cnpj);

                //Informações do Endereço da Loja
                System.out.println("\nInforme o Estado da Loja: ");
                String estado = this.scanner.nextLine();
                endereco.setEstado(estado);
                System.out.println("Informe a Cidade da Loja:");
                String cidade = this.scanner.nextLine();
                endereco.setCidade(cidade);
                System.out.println("Informe o Bairro da Loja: ");
                String bairro = this.scanner.nextLine();
                endereco.setBairro(bairro);
                System.out.println("Informe a Rua da Loja: ");
                String rua  = this.scanner.nextLine();
                endereco.setRua(rua);
                System.out.println("Informe o Numero da Loja: ");
                String numero = this.scanner.nextLine();
                endereco.setNumero(numero);
                System.out.println("Informe o Complemento da Loja:      (Caso não tenha digite 'N/A' )");
                String complemento = this.scanner.nextLine();
                endereco.setComplemento(complemento);

                loja.setEndereco(endereco);
                lojas.add(loja);

                System.out.println("Loja cadastrada com sucesso!");
                System.out.println("=========================");
            }
            case 2 -> {
                if (lojas.isEmpty()) {
                    System.out.println("Nenhuma loja cadastrada.");
                } else {
                    for (Loja loja : lojas) {
                        loja.apresentarSe();
                        loja.contarClientes();
                        loja.contarVendedores();
                    }
                }
                System.out.println("=========================");
            }
            case 3 -> {
                System.out.println("Informe o nome da Loja: ");
                String nome = this.scanner.nextLine();
                try {
                    menuLoja(nome);
                } catch (java.text.ParseException e) {
                    System.out.println("Erro ao processar a data: " + e.getMessage());
                }
            }
            case 0 ->{
                return;
            } 
            default -> {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }if (opcao != 0) {
            menuPrincipal(); // Chama o menu novamente
        }
    }

    private void menuLoja(String nome) throws java.text.ParseException {
        Loja loja = lojas.stream()
        .filter(l -> l.getNomeFantasia().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
        if (loja == null) {
            System.out.println("Loja não encontrada.");
            return;
        }


        System.out.println("--- Menu da Loja ---");
        System.out.println("1. Cadastrar Vendedor ");
        System.out.println("2. Cadastrar Cliente ");
        System.out.println("3. Criar Pedido ");
        System.out.println("0. Sair ");
        System.out.println("=========================");
        Integer opcao = this.scanner.nextInt();
        this.scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                Endereco enderecoVendedor = new Endereco();
                // Cadastrar Vendedor 
                System.out.println("Informe o nome do vendedor: ");
                String nomeVendedor = this.scanner.nextLine();
                System.out.println("Informe a idade do vendedor: ");
                Integer idade = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Informe o salário base do vendedor: ");
                Double salarioBase = this.scanner.nextDouble();
                this.scanner.nextLine();

                 //Informações do Endereço da Vendedor
                System.out.println("\nInforme o Estado da Loja: ");
                String estado = this.scanner.nextLine();
                enderecoVendedor.setEstado(estado);
                System.out.println("Informe a Cidade da Loja:");
                String cidade = this.scanner.nextLine();
                enderecoVendedor.setCidade(cidade);
                System.out.println("Informe o Bairro da Loja: ");
                String bairro = this.scanner.nextLine();
                enderecoVendedor.setBairro(bairro);
                System.out.println("Informe a Rua da Loja: ");
                String rua  = this.scanner.nextLine();
                enderecoVendedor.setRua(rua);
                System.out.println("Informe o Numero da Loja: ");
                String numero = this.scanner.nextLine();
                enderecoVendedor.setNumero(numero);
                System.out.println("Informe o Complemento da Loja:      (Caso não tenha digite 'N/A' )");
                String complemento = this.scanner.nextLine();
                enderecoVendedor.setComplemento(complemento);

                // Instanciando o vendedor 
                Vendedor vendedor = new Vendedor(nomeVendedor, idade, loja, enderecoVendedor, salarioBase, new ArrayList<>());

                // Cadastrando o vendedor na Loja
                loja.cadastrarVendedor(vendedor);
                System.out.println("Vendedor cadastrado com sucesso!");
            }
            case 2 -> {
                Cliente cliente = new Cliente();
                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = this.scanner.nextLine();
                cliente.setNome(nomeCliente);
                System.out.println("Informe a idade do cliente: ");
                Integer idade = this.scanner.nextInt();
                this.scanner.nextLine();
                cliente.setIdade(idade);

                loja.cadastrarCliente(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
            }
            case 3 -> {
                // Criar  Pedido
                Date dataCriacao = new Date(); // Parsing date
                System.out.println("Informe a data para o vencimento do pedido: ");
                String dataVencimentoReservaStr = this.scanner.nextLine();
                Date dataVencimentoReserva = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dataVencimentoReservaStr);

                Pedido pedido = new Pedido();
                pedido.setPedidoId();
                pedido.setDataCriacao(dataCriacao);
                pedido.setDataVencimentoReserva(dataVencimentoReserva);

                System.out.println("Pedido cadastrado com sucesso!");

                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = this.scanner.nextLine();

                Cliente cliente = loja.getClientes().stream()
                    .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                    .findFirst()
                    .orElse(null);

                if (cliente == null) {
                    System.out.println("Cliente não encontrado. ");
                    return;
                }

                System.out.println("Informe o nome do vendedor: ");
                String nomeVendedor = this.scanner.nextLine();
                Vendedor vendedor = loja.getVendedores().stream()
                    .filter(v -> v.getNome().equalsIgnoreCase(nomeVendedor))
                    .findFirst()
                    .orElse(null);
                if (vendedor == null) {
                    System.out.println("Vendedor não encontrado. ");
                    return;
                }

                pedido.setCliente(cliente);
                pedido.setVendedor(vendedor);
                pedido.setLoja(loja);
                menuPedido(pedido,cliente,loja,vendedor);
            }
            case 0 -> {
                return;
            }
        } if (opcao != 0) {
            menuLoja(nome); // Chama o menu novamente
        }
    }
    public void menuPedido(Pedido pedido,Cliente cliente, Loja loja, Vendedor vendedor) {
        System.out.println("--- Menu do Pedido ---");
        System.out.println("1. Adicionar Item ao Pedido ");
        System.out.println("2. Calcular Valor Total do Pedido ");
        System.out.println("3. Processar Pedido ");
        System.out.println("0. Sair ");
        System.out.println("=========================");
        Integer opcao = this.scanner.nextInt();
        this.scanner.nextLine();
        switch (opcao) {
            case 1 -> {
                Item item = new Item();
                System.out.println("Informe o ID do item: ");
                Integer id = this.scanner.nextInt();
                this.scanner.nextLine();
                item.setId(id);
                System.out.println("Informe o nome do item: ");
                String nome = this.scanner.nextLine();
                item.setNome(nome);
                System.out.println("Informe o tipo do item: ");
                String tipo = this.scanner.nextLine();
                item.setTipo(tipo);
                System.out.println("Informe o valor do item: ");
                Double valor = this.scanner.nextDouble();
                this.scanner.nextLine();
                item.setValor(valor);
                System.out.println("Informe a quantidade do item: ");
                Integer quantidade = this.scanner.nextInt();
                this.scanner.nextLine();
                item.setQuantidade(quantidade);

                pedido.adicionarItensAoPedido(item);
            }
            case 2 -> {
                pedido.calcularValorTotalPedido();
                pedido.gerarDescricaoVenda();
            }
            case 3 -> {
                ProcessarPedido processaPedido = new ProcessarPedido();
                processaPedido.processarPedido(pedido);
            }
            case 0 -> {
                return;
            }
        } if (opcao != 0) {
            menuPedido(pedido,cliente,loja,vendedor); // Chama o menu novamente
        }

    }
}
