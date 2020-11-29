package materiais.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Compra {

	@Id
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_Deposito")
	private Deposito deposito;
	
	@ManyToOne
	@JoinColumn(name ="id_produto")
	private Produto produto;
	
	private int qtdeComprada = 0;
	
	@ManyToOne
	@JoinColumn(name="cpf_Funcionario")
	@Fetch(FetchMode.JOIN)
	private Funcionario funcionario;
	
	@OneToOne
	@Column(name ="id_NotaFiscal")
	private NotaFiscal notaFiscal;
	
	//Construtores
	public Compra() {}
	
	public Compra(Deposito deposito, Produto produto, Funcionario funcionario, int qtdeComprada) {
		this.deposito = deposito;
		this.funcionario = funcionario;
		this.produto = produto;
		this.qtdeComprada = qtdeComprada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQtdeComprada() {
		return qtdeComprada;
	}

	public void setQtdeComprada(int qtdeComprada) {
		this.qtdeComprada = qtdeComprada;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	
}


