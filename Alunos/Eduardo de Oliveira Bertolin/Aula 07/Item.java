package calculadoraplantas;

public class Item{
    int id;
    String nome;
    String tipo;
    double valor;
    
    public void gerarDescricao(){
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor : " + valor);
        }
    }