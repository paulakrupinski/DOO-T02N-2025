package Alunos.FelipeHeringer.Aula06;

public class Main {
    public static void main(String[] args) {
        Loja lojaGabrielinha = new Loja();
        lojaGabrielinha.setNomeFantasia("Gabrielinha Loja de Plantas");
        lojaGabrielinha.setCnpj("123456789");
        lojaGabrielinha.setCidade("Belo Horizonte");
        lojaGabrielinha.setBairro("Savassi");
        lojaGabrielinha.setRua("Rua da Bahia");
        lojaGabrielinha.apresentarSe();
        System.out.println("-----------------------------------------------------------");

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNome("Felipe");
        vendedor1.setIdade(21);
        vendedor1.setLoja(lojaGabrielinha);
        lojaGabrielinha.cadastrarVendedor(vendedor1);

        Vendedor vendedor2 = new Vendedor();
        vendedor2.setNome("Jorge");
        vendedor2.setIdade(35);
        vendedor2.setLoja(lojaGabrielinha);
        lojaGabrielinha.cadastrarVendedor(vendedor2);
        vendedor2.setSalarioBase(2000.0);
        vendedor2.calcularBonusSalario();
        System.out.println("-----------------------------------------------------------");

        Vendedor vendedor3 = new Vendedor();
        vendedor3.setNome("Ana");
        vendedor3.setIdade(28);
        vendedor3.setLoja(lojaGabrielinha);
        lojaGabrielinha.cadastrarVendedor(vendedor3);
        
        lojaGabrielinha.contarVendedores();
        lojaGabrielinha.getVendedores().forEach(vendedor -> {
            vendedor.apresentarSe();
            System.out.println("Média salarial: " + vendedor.calcularMediaSalarios());
            System.out.println("-----------------------------------------------------------");
        });

        Cliente cliente1 = new Cliente();
        cliente1.setNome("João");
        cliente1.setIdade(19);
        lojaGabrielinha.cadastrarCliente(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Bruna");
        cliente2.setIdade(22);
        lojaGabrielinha.cadastrarCliente(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Seu Zé");
        cliente3.setIdade(64);
        lojaGabrielinha.cadastrarCliente(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Maria");
        cliente4.setIdade(55);
        lojaGabrielinha.cadastrarCliente(cliente4);

        lojaGabrielinha.contarClientes();
        lojaGabrielinha.getClientes().forEach(cliente -> {
            cliente.apresentarSe();
            System.out.println("-----------------------------------------------------------");
        });
    }
}
