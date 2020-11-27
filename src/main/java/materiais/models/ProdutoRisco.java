package materiais.models;

import javax.persistence.Entity;

@Entity
public class ProdutoRisco extends Produto {


	private String grauRisco;
	private String tipoRisco;
	private String orientacaoSeguranca;
	
	public String getGrauRisco() {
		return grauRisco;
	}
	public void setGrauRisco(String grauRisco) {
		this.grauRisco = grauRisco;
	}
	public String getTipoRisco() {
		return tipoRisco;
	}
	public void setTipoRisco(String tipoRisco) {
		this.tipoRisco = tipoRisco;
	}
	public String getOrientacaoSeguranca() {
		return orientacaoSeguranca;
	}
	public void setOrientacaoSeguranca(String orientacaoSeguranca) {
		this.orientacaoSeguranca = orientacaoSeguranca;
	}
	
	
	
}
