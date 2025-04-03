public class Main {
    public static void main(String[] args) {
        Loja l1 = new Loja();

        l1.setNomeFantasia("Gabrielinha loja de plantas");
        l1.setCnpj("12.345.678/0001-00");
        l1.setCidade("Cascavel");
        l1.setBairro("Pioneiros Catarinense");
        l1.setRua("Rua Enandes de Oliveira");

        Vendedor v1 = new Vendedor();
        Vendedor v2 = new Vendedor();
        Vendedor v3 = new Vendedor();

        v1.setNome("Jorge");
        v1.setIdade(25);
        v1.setLoja(l1);

        v2.setNome("Marina");
        v2.setIdade(18);
        v2.setLoja(l1);

        v3.setNome("Nilva");
        v3.setIdade(43);
        v3.setLoja(l1);

        l1.cadastraVendedor(v1);
        l1.cadastraVendedor(v2);
        l1.cadastraVendedor(v3);

        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setNome("Luiz");
        c1.setIdade(67);

        c2.setNome("Fernando");
        c2.setIdade(18);

        c3.setNome("Giovana");
        c3.setIdade(27);

        l1.cadastraCliente(c1);
        l1.cadastraCliente(c2);
        l1.cadastraCliente(c3);

        l1.apresentarse();

        v1.calcularBonus();

        v1.calcularMedia();
        v2.calcularMedia();
        v3.calcularMedia();
    }
}
