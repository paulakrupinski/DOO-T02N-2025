public class Quartos {
       
    int camas;
    int número;
    int data;
    boolean disp;

public Quartos(int camas, int número,boolean disp){ 
    this.camas = camas;
    this.número = número;
    this.disp = disp;

}
public void info(){
    System.out.printf("Camas: %s Número: %s Disponibilidade: %b ", camas, número, disp);
}
}


