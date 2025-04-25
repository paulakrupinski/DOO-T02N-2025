import java.util.Scanner;

public class PedidoService {

    Scanner scanner = new Scanner(System.in);

    public void criarEProcessarPedidoFake() {
        Item item1 = new Item(1, "Planta", "Ornamental", 50.0);
        Item item2 = new Item(2, "Vaso", "Decoração", 30.0);
        Item[] itens = {item1, item2};
    }

}
