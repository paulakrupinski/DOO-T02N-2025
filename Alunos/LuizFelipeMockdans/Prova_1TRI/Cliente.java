public class Cliente {
    private static int nextId = 1;
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    
    public Cliente(String nome, String cpf, String telefone) {
        this.id = nextId++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}