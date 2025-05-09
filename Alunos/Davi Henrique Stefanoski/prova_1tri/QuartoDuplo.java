package pacote;

public class QuartoDuplo extends Quarto {
	
	 public QuartoDuplo (int numero) {
		 super(numero);
		 this.capacidade = 4;
	 }
	 

	 @Override
	 public  void calcularPreco(int quantidadeDeDiarias) {
		 float preco = 400 * quantidadeDeDiarias;
		 System.out.println("O valor total a pagar é de: R$" +preco);
	} {
		 
	 }
}
