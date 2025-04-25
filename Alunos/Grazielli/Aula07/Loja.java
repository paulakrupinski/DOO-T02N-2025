import java.util.Scanner;

public class Loja {
    String nomeFantasia, razaoSocial, cnpj;
    Endereco endereco;
    Vendedor[] vendedores = new Vendedor[10];
    Cliente[] clientes = new Cliente[10];
    Gerente[] gerentes = new Gerente[5];
    int contadorVendedores = 0, contadorClientes = 0, contadorGerentes = 0;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void adicionarVendedor(Vendedor v) {
        if (contadorVendedores < vendedores.length) {
            vendedores[contadorVendedores++] = v;
        }
    }

    public void adicionarCliente(Cliente c) {
        if (contadorClientes < clientes.length) {
            clientes[contadorClientes++] = c;
        }
    }

    public void adicionarGerente(Gerente g) {
        if (contadorGerentes < gerentes.length) {
            gerentes[contadorGerentes++] = g;
        }
    }

    public int contarClientes() {
        return contadorClientes;
    }

    public int contarVendedores() {
        return contadorVendedores;
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }
}
