package Alunos.Pedro_Pires.Aula01.Aula02;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
    	
    
        Scanner scan = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
 	   
        System.out.print(
               "[1] - Calcular Preço Total\n" +
               "[2] - Calcular Troco\n" +
               "[3] - Sair");
        
        int options = scan.nextInt();
        
        while(options != 3) {
        	switch(options) {
        	case 1:{
        		System.out.println("Digite o valor do produto: ");
        		double valor = scan.nextDouble();
        		System.out.println("Digite a quantidade: ");
        		int quantidade = scan.nextInt();
        		calculadora = new Calculadora (valor, quantidade);
        		calculadora.precoTotal();
        		break;
        	}
        	case 2:
        	{
        		System.out.println("Digite o valor do troco: ");
        		double troco = scan.nextDouble();
        		calculadora.troco(troco);
        		break;
        	}
        	}

            System.out.print(
                   "[1] - Calcular Preço Total\n" +
                   "[2] - Calcular Troco\n" +
                   "[3] - Sair");
            
        	 options = scan.nextInt();
        	
        }
   }
	
       
        
     
}
