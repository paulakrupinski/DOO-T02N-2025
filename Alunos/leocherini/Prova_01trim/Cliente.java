package provaBum;

class Cliente {
    private int id;
    private String nome;
    private boolean hospedado;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.hospedado = false;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isHospedado() {
        return hospedado;
    }

    public void setHospedado(boolean hospedado) {
        this.hospedado = hospedado;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}