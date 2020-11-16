package materiais.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Deposito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String endereco;
	
	private String tipo;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IdDeposito")
	@Fetch(FetchMode.JOIN)
	private List<Produto> produtos;
	
	
	public Deposito() {}
	
	public Deposito(String nome, String endereco, String tipo, List<Produto> produtos) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.produtos = produtos;
	}
	
	public Deposito(String nome, String endereco, String tipo) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	

	
	

}
