package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Quarto {

    private Integer numero;
    private Boolean reservado;
    private TipoQuarto tipoQuarto;
    private Double valorDiaria;

    public Quarto(Integer numero, Integer tipoQuartoNumerico) {
        this.numero = numero;
        this.reservado = false;
        if (tipoQuartoNumerico == 1) {
            this.tipoQuarto = TipoQuarto.SIMPLES;
            this.valorDiaria = 250.00;
        } else {
            this.tipoQuarto = TipoQuarto.DUPLO;
            this.valorDiaria = 500.00;
        }
    }

    public Quarto() {
        this.numero = 0;
    }

    public static Boolean verificaQuartoReservado(ArrayList<Quarto> listaQuartos, Integer numeroQuarto) {
        for (Quarto quarto : listaQuartos) {
            if ((Objects.equals(quarto.getNumero(), numeroQuarto)) && quarto.reservado) {
                return true;
            }
        }
        return false;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Boolean isEmpty() {
        return this.numero <= 0;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", reservado=" + reservado +
                ", tipoQuarto=" + tipoQuarto +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
