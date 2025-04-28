package Prova_1TRI;

import java.util.Scanner;

public class Quartos {
    private int numeroQuarto;
    private String tipoQuarto;
    private double valorQuarto;
    private boolean disponivel;

    public Quartos(int numeroQuarto, String tipoQuarto, double valorQuarto) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.valorQuarto = valorQuarto;
        this.disponivel = true;
    }

    public Quartos() {
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public double getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(double valorQuarto) {
        this.valorQuarto = valorQuarto;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void cadastrarQuarto() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite o número do quarto: ");
        this.numeroQuarto = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Escolha o tipo de quarto:");
        System.out.println("1. Simples");
        System.out.println("2. Duplo");
        int tipo = scanner.nextInt();
    
        if (tipo == 1) {
            this.tipoQuarto = "Simples";
            System.out.print("Digite o valor do quarto simples: ");
            this.valorQuarto = scanner.nextDouble();
        } else if (tipo == 2) {
            this.tipoQuarto = "Duplo";
            System.out.print("Digite o valor do quarto duplo: ");
            double valorSimples = scanner.nextDouble();
    
            // Verifica se o valor do quarto duplo é inferior a 200 reais
            if (valorSimples < 200) {
                System.out.println("Erro: O valor do quarto duplo não pode ser inferior a 200 reais.");
                return;  // Impede o cadastro se o valor for menor que 200
            }
    
            this.valorQuarto = valorSimples + 200;  // Duplo é 200 reais mais caro
        } else {
            System.out.println("Opção inválida.");
            return;
        }
    
        this.disponivel = true;
        System.out.println("Quarto cadastrado com sucesso!");
    }
    
}
