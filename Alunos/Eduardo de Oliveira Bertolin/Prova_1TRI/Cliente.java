package sistemahotel;

public class Cliente {
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String aniversario;
    private Endereco endereco;
    private String tipoQuarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private boolean hospedado;
    int quantidadeDias;

    public Cliente(String nome, String cpf, String celular, String email, 
            String aniversario, Endereco endereco, String tipoQuarto, 
            String dataCheckIn, String dataCheckOut, int quantidadeDias){
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.aniversario = aniversario;
        this.endereco = endereco;
        this.tipoQuarto = tipoQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.hospedado = false;
        this.quantidadeDias = quantidadeDias;
    }

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Celular: " + celular);
        System.out.println("Email: " + email);
        System.out.println("Data de Nascimento: " + aniversario);
        System.out.println("Endereço: " + endereco.getEndereco());
        System.out.println("Tipo de quarto: " + tipoQuarto);
        System.out.println("Data de Check-In: " + dataCheckIn);
        System.out.println("Data de Check-Out: " + dataCheckOut);
        System.out.println("Dias de hospedagem: " + quantidadeDias);
    }

    public void realizarCheckIn(){
        if(!hospedado){
            hospedado = true;
            System.out.println(nome + " fez o check-in em " + dataCheckIn);
        } else {
            System.out.println(nome + " já fez o check-in.");
        }
    }

    public void realizarCheckOut(){
        if(hospedado){
            hospedado = false;
            System.out.println(nome + " fez o check-out em " + dataCheckOut);
        } else {
            System.out.println(nome + " não está hospedado.");
        }
    }
}
