package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.ProdutoRisco;
import materiais.services.ProdutoRiscoService;


public class ProdutoRiscoController {

	@Autowired
	ProdutoRiscoService produtoRiscoService;
	
	public ResponseEntity<List<ProdutoRisco>> getAll() {
		return produtoRiscoService.getAll();
	}
	
	public ResponseEntity<ProdutoRisco> getById(long id) {
		return produtoRiscoService.getById(id);
	}
	
	public ResponseEntity<ProdutoRisco> create(ProdutoRisco produtoRisco) {
		if(verifyProdutoRisco(produtoRisco.getId())) {
			return null;
		}
		
		return produtoRiscoService.create(produtoRisco);
	}
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return produtoRiscoService.delete(id);
	}
	
	public boolean verifyProdutoRisco(long id) {
		
		ResponseEntity<ProdutoRisco> produtoRisco = produtoRiscoService.getById(id);
		
		if (produtoRisco.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}
}
