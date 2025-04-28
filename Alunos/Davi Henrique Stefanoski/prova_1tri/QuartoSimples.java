package pacote;

public class QuartoSimples extends Quarto {
	
	 public QuartoSimples (int numero) {
		 super(numero);
		 this.capacidade = 2;
	 }
	 

	 @Override
	 public  void calcularPreco(int quantidadeDeDiarias) {
		 float preco = 200 * quantidadeDeDiarias;
		 System.out.println("O valor total a pagar é de: R$" +preco);
	} {
		 
	 }
}

