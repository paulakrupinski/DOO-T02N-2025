package Prova_1TRI;
import java.util.Scanner;

public class Clientes {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    // Construtor padrão
    public Clientes() {}

    // Construtor com parâmetros
    public Clientes(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método de cadastro (agora não-estático)
    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        this.nome = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        this.cpf = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        this.endereco = scanner.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        this.telefone = scanner.nextLine();

        System.out.println("Cliente cadastrado com sucesso!");
    }
}
