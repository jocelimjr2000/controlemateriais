package materiais.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class NotaFiscal {

	@Id
	private long numero;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCompra;

	private int quantidadeComprada;

	private Double valorCompra;
	
	
	public NotaFiscal () {}
	
	public NotaFiscal(int qtdeComprada, Double valorCompra) {
		this.quantidadeComprada = qtdeComprada;
		this.valorCompra = valorCompra;
	}
	

	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}



}
