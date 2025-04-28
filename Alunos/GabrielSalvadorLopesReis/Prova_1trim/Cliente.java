package Prova_1trim;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nome;

    static private List<Cliente> clientes = new ArrayList<Cliente>();
    static private Integer proximoId = 0;

    public Cliente() {
        this.id = proximoId++;
    }

    public Cliente(String nome) {
        this.id = proximoId++;
    }

    public static void adicionarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Nome:");
        cliente.setNome(Menu.sc.nextLine());

        clientes.add(cliente);
    }

    public static void listarClientes() {
        System.out.println("Clientes");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public static Cliente capturarCliente(Integer id) {
        for (Cliente cliente : clientes) {
            if (cliente.id.equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id: " + id + " | nome: " + nome;
    }
}
