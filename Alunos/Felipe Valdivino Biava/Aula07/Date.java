package Aula07;

public class Date {
    private java.util.Date dataCriacao;
    private java.util.Date dataPagamento;
    private java.util.Date dataVencimentoReserva;

    public java.util.Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(java.util.Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public java.util.Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(java.util.Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public java.util.Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(java.util.Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    @Override
    public String toString() {
        return "Date{" +
                "dataCriacao=" + dataCriacao +
                ", dataPagamento=" + dataPagamento +
                ", dataVencimentoReserva=" + dataVencimentoReserva +
                '}';
    }
}
