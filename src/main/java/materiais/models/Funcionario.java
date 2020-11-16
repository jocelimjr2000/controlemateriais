package materiais.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	private long cpf;
	
	private String nome;
	
	private String cargo;
	
	
	//Contrutores
	public Funcionario() {}
	
	public Funcionario(long cpf,String nome, String cargo) {
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
	}
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	
}
