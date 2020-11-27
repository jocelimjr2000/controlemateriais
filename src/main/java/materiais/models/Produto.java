package materiais.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String codigoFabricante;

	private String nome;

	private Double custo;

	private int quantidadeArmazenada = 0;

	private int quantidadeMaxima;

	private int quantidadeMinima;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="IdDeposito")
	@Fetch(FetchMode.JOIN)
	private Deposito deposito;


	//Construtores
	public Produto (){}


	//
	public Produto(String nome, int quantidadeArmazenada, int quantidadeMaxima, int quantidadeMinima) {
		super();
		this.nome = nome;
		this.custo = custo;
		this.quantidadeArmazenada = quantidadeArmazenada;
		this.quantidadeMaxima = quantidadeMaxima;
		this.quantidadeMinima = quantidadeMinima;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCodigoFabricante() {
		return codigoFabricante;
	}


	public void setCodigoFabricante(String codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}


	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getCusto() {
		return custo;
	}


	public void setCusto(Double custo) {
		this.custo = custo;
	}


	public int getQuantidadeArmazenada() {
		return quantidadeArmazenada;
	}


	public void setQuantidadeArmazenada(int quantidadeArmazenada) {
		this.quantidadeArmazenada = quantidadeArmazenada;
	}


	public int getQuantidadeMaxima() {
		return quantidadeMaxima;
	}


	public void setQuantidadeMaxima(int quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}


	public Deposito getDeposito() {
		return deposito;
	}


	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}


	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

}
