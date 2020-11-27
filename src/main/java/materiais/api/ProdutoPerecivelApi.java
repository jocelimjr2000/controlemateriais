package materiais.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import materiais.controllers.ProdutoPerecivelController;
import materiais.models.ProdutoPerecivel;

@Controller
@RequestMapping("/api/produtoperecivel")
public class ProdutoPerecivelApi {

	@Autowired
	ProdutoPerecivelController produtoPerecivelController;
	
	@GetMapping("/")
	public ResponseEntity<List<ProdutoPerecivel>> getAll(){
		return produtoPerecivelController.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<ProdutoPerecivel> create(@RequestBody ProdutoPerecivel produtoPerecivel){
		return this.produtoPerecivelController.create(produtoPerecivel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoPerecivel> getById(@PathVariable("id") long id){
		return produtoPerecivelController.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return produtoPerecivelController.delete(id);
	}
}
