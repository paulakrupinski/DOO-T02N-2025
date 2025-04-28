package pacote;
import java.util.Date;

public class Reserva {
int id;
Cliente cliente;
Quarto quarto;
Date dataInicio;
Date dataFim;
boolean checkInRealizado;
boolean checkOutRealizado;

public Reserva(int id, Cliente cliente, Quarto quarto) {
	this.id = id;
	this.cliente = cliente;
	this.quarto = quarto;
	this.checkInRealizado = false;
	this.checkOutRealizado = false;
}

public void realizarCheckIn() {
	quarto.setDisponivel(false);
	this.dataInicio = new Date();
	this.checkInRealizado = true;
}

public void realizarCheckOut() {
	quarto.setDisponivel(true);
	this.dataFim = new Date();
	this.checkOutRealizado = true;
}

public int getQuantidadeDeDiarias() {
    if (dataInicio == null || dataFim == null) {
    	System.out.println("Sem os dados necessários para fazer o calculo");
        return 0;
    }

    long diferencaMillis = dataFim.getTime() - dataInicio.getTime();
    long milissegundosPorDia = 1000 * 60 * 60 * 24;

    return (int) (diferencaMillis / milissegundosPorDia);
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Quarto getQuarto() {
	return quarto;
}

public void setQuarto(Quarto quarto) {
	this.quarto = quarto;
}

public Date getDataInicio() {
	return dataInicio;
}

public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
}

public Date getDataFim() {
	return dataFim;
}

public void setDataFim(Date dataFim) {
	this.dataFim = dataFim;
}

public boolean isCheckInRealizado() {
	return checkInRealizado;
}

public void setCheckInRealizado(boolean checkInRealizado) {
	this.checkInRealizado = checkInRealizado;
}

public boolean isCheckOutRealizado() {
	return checkOutRealizado;
}

public void setCheckOutRealizado(boolean checkOutRealizado) {
	this.checkOutRealizado = checkOutRealizado;
}


}



