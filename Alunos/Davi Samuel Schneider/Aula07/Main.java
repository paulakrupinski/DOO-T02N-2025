package domain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        executar();
    }

    public static void executar() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            menu();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Loja.cadastrarVendedor();
                    break;
                case 2:
                    Loja.apresentarVendedores();
                    break;
                case 3:
                    Loja.calcularMediaPeloNome();
                    break;
                case 4:
                    Loja.calcularBonusPeloNome();
                    break;
                case 5:
                    Loja.cadastrarCliente();
                    break;
                case 6:
                    Loja.apresentarClientes();
                    break;
                case 7:
                    Loja.apresentarse();
                    break;
                case 8:
                    System.out.println(Loja.contarVendedores());
                    break;
                case 9:
                    System.out.println(Loja.contarClientes());
                    break;
                case 10:
                    Loja.cadastrarGerente();
                    break;
                case 11:
                    Loja.criarPedido();
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        } while (true);
    }


    public static void menu() {
        System.out.println("                    -------MENU------");
        System.out.println("1 - Cadastrar Vendedor          5 - Cadastrar Cliente                9 - Contar clientes");
        System.out.println("2 - Apresentar Vendedor         6 - Apresentar Cliente               10- Cadastrar Gerente");
        System.out.println("3 - Calcular Média              7 - Apresentar loja                  11 - Criar pedido");
        System.out.println("4 - Calcular Bônus              8 - Contar vendedores                0 - Sair");
    }

}
