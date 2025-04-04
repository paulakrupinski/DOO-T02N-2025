public class Main {
  public static void main(String[] args) {
      Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", "Cascavel", "Centro", "Rua das Flores");

      Vendedor vendedor1 = new Vendedor("Carlos", 30, "My Plant", "Cascavel", "Centro", "Rua A", 2500.00);
      Vendedor vendedor2 = new Vendedor("Ana", 28, "My Plant", "Cascavel", "Centro", "Rua B", 2600.00);

      Cliente cliente1 = new Cliente("Maria", 45, "Cascavel", "Centro", "Rua C");
      Cliente cliente2 = new Cliente("João", 35, "Cascavel", "Centro", "Rua D");

      myPlant.adicionaVendedor(vendedor1);
      myPlant.adicionaVendedor(vendedor2);
      myPlant.adicionaCliente(cliente1);
      myPlant.adicionaCliente(cliente2);

      myPlant.apresentarse();

      System.out.println("Total de Vendedores: " + myPlant.contarVendedores());
      System.out.println("Total de Clientes: " + myPlant.contarClientes());

      vendedor1.apresentarse();
      System.out.println("Média Salarial: " + vendedor1.calcularMedia());
      System.out.println("Bônus: " + vendedor1.calcularBonus());

      cliente1.apresentarse();
  }
}
