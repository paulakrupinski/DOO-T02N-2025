package Alunos.LuanGuex.Prova_1Tri;

public class Quarto extends Cliente {

    int diaria; 
    int tipo = 0;   
    Boolean disp = true;
    Boolean checkin = false;
    Boolean checkout = false;


    Quarto(int diaria, String nome, int tipo, Boolean disp, Boolean checkin, Boolean checkout){
        super(nome);
        this.diaria = 0;
        this.tipo = tipo;
        this.disp = disp;
        this.checkin = checkin;
        this.checkout = checkout;

    }

    public void infoCliente(){
        super.info();
        System.out.println("Diaria: " + diaria);
        tipoQuarto();

        if (checkin == true){

            System.out.println("Checking: Realizado");

        } else {

            System.out.println("Checking: Não Realizado");

        }

        if (checkout == true){

            System.out.println("Checkout: Realizado");

        } else {

            System.out.println("Checkout: Não Realizado");

        }
    }

    public void infoQuarto(){

        if (tipo == 1){

            System.out.println("Quarto: Simples");
        } else {

            System.out.println("Quarto: Duplo");
        }

        if (disp == true){
            
            System.out.println("Disponível");

        } else {
            System.out.println("Reservado");
        }
        
    }

    public void tipoQuarto(){

        if (tipo == 0 || tipo > 2){
         
            System.out.println("Nenhum quarto!");
        
        } else if (tipo == 1){

            System.out.println("Quarto: Simples");
        } else {

            System.out.println("Quarto: Duplo");

        }

    }
}
