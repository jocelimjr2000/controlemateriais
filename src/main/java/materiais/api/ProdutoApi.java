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

import materiais.controllers.ProdutoController;
import materiais.models.Produto;


@Controller
@RequestMapping("/api/Produto")
public class ProdutoApi {

	@Autowired
	ProdutoController produtoController;
	
	@GetMapping("/")
	public ResponseEntity<List<Produto>> getAll(){
		return produtoController.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Produto> create(@RequestBody Produto produto){
		return produtoController.create(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") long id){
		return produtoController.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return produtoController.delete(id);
	}
}
