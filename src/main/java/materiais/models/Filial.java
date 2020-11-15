package materiais.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Filial {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IdFIial")
	@Fetch(FetchMode.JOIN)
	private List<Deposito> depositos;
	
	
	public Filial() {}


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


	public List<Deposito> getDepositos() {
		return depositos;
	}


	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}
	
	
}
