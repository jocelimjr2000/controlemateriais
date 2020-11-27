package materiais.models;

import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class ProdutoPerecivel extends Produto {
	
	private Calendar dataValidade;

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
	

}
