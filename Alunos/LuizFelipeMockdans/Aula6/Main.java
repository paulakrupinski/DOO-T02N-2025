public class Main {
    public static void main(String[] args) {

        Loja l1 = new Loja("Gabrielinha Loja de Plantas", "Gabrielinha Plantas LTDA", "12.345.678/0001-00", 
                           "Cascavel", "Pioneiros Catarinense", "Rua Enandes de Oliveira");

        
        Vendedor v1 = new Vendedor("Jorge", 25, l1);
        Vendedor v2 = new Vendedor("Marina", 18, l1);
        Vendedor v3 = new Vendedor("Nilva", 43, l1);

     
        l1.cadastraVendedor(v1);
        l1.cadastraVendedor(v2);
        l1.cadastraVendedor(v3);


        Cliente c1 = new Cliente("Luiz", 67);
        Cliente c2 = new Cliente("Fernando", 18);
        Cliente c3 = new Cliente("Giovana", 27);

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
