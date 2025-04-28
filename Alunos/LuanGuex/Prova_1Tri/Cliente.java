package Alunos.LuanGuex.Prova_1Tri;

public class Cliente {

    String nome;

    Cliente(String nome){
        this.nome = nome;
    }
    
    public void info(){
        System.out.println("Cliente: " + nome);
    }

}
