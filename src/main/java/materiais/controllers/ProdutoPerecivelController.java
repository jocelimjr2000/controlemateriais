package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.ProdutoPerecivel;
import materiais.services.ProdutoPerecivelService;


public class ProdutoPerecivelController {
	
	@Autowired
	ProdutoPerecivelService produtoPerecivelService;
	
	public ResponseEntity<List<ProdutoPerecivel>> getAll() {
		return produtoPerecivelService.getAll();
	}
	
	public ResponseEntity<ProdutoPerecivel> getById(long id) {
		return produtoPerecivelService.getById(id);
	}
	
	public ResponseEntity<ProdutoPerecivel> create(ProdutoPerecivel produtoPerecivel) {
		if(verifyProdutoPerecivel(produtoPerecivel.getId())) {
			return null;
		}
		
		return produtoPerecivelService.create(produtoPerecivel);
	}

	public ResponseEntity<HttpStatus> delete(long id) {
		return produtoPerecivelService.delete(id);
	}
	
	public boolean verifyProdutoPerecivel(long id) {
		
		ResponseEntity<ProdutoPerecivel> produtoPerecivel = produtoPerecivelService.getById(id);
		
		if (produtoPerecivel.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}

}
