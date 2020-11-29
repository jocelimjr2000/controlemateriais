package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import materiais.models.Produto;

import materiais.services.ProdutoService;

public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	public ResponseEntity<List<Produto>> getAll() {
		return produtoService.getAll();
	}
	
	public ResponseEntity<Produto> getById(long id) {
		return produtoService.getById(id);
	}
	
	public ResponseEntity<Produto> create(Produto produto) {
		if(verifyProduto(produto.getId())) {
			return null;
		}
		
		return produtoService.create(produto);
	}
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return produtoService.delete(id);
	}
	
	public boolean verifyProduto(long id) {
		
		ResponseEntity<Produto> notaFiscal = produtoService.getById(id);
		
		if (notaFiscal.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}
	public Produto verifyQuantity(Produto produto, int qtdeInserida){
		if (produto.getQuantidadeArmazenada() + qtdeInserida <= produto.getQuantidadeMaxima()) {
			produto.setQuantidadeArmazenada(produto.getQuantidadeArmazenada() + qtdeInserida);
			return produto;
		} else {
			return null;
		}
	}

}
