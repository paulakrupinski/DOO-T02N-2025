package application;

import Entities.Costumer;
import Entities.Seller;
import Entities.Store;

import java.io.Console;
import java.util.Scanner;

public class Calculadora {




    public static void main(String[] args) {

    }


    public void menu(){
        Seller seller = new Seller();
        Costumer costumer = new Costumer();
        Store store = new Store();
        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha um opcao:\n 1- Vendedor \n2- Cliente \n3-Loja \n4-Sair");
        int option = scan.nextInt();
        switch(option){
            case 1:{
                System.out.println("Escolha um opcao:\n 1- Apresentar Vendedor \n2- Media Salarial \n3- Bonus Salarial");
                option = scan.nextInt();
                switch(option){
                    case 1:{
                        seller.apresentarSe();
                        break;
                    }
                    case 2:{
                        seller.calcularMedia();
                        break;
                    }
                    case 3:{
                        seller.calcularBonus();
                    }

                }
                break;
            }

        }

    }

}


