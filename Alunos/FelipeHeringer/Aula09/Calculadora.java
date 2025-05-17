package Alunos.FelipeHeringer.Aula09;

public class Calculdora {
    private double num1;
    private double num2;

    public Calculdora(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    private double somarNumeros(double num1, double num2){
        System.out.println("Realizando a soma dos numeros: " + num1 + " " + num2);

        return num1 + num2;

    }

    private double subtrairNumeros(double num1, double num2){
        System.out.println("Realizando a subtração dos numeros: " + num1 + " " + num2);

        return num1 - num2;
    }

    private double multiplicarNumeros(double num1, double num2){
        System.out.println("Realizando a multiplicação dos numeros: " + num1 + " " + num2);

        return num1 * num2;

    }

    private double dividirNumeros(double num1, double num2) {
        System.out.println("Realizando a divisão dos numeros: " + num1 + " " + num2);

        if(num2 == 0){
            throw new ArithmeticException("Não é possivel realizar uma divisão por zero");
        }

        return num1 / num2;
    }
    
}
