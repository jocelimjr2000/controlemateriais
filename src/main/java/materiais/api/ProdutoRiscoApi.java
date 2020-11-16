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

import materiais.models.ProdutoRisco;
import materiais.services.ProdutoRiscoService;

@Controller
@RequestMapping("/api/produtorisco")
public class ProdutoRiscoApi {

	@Autowired
	ProdutoRiscoService produtoRiscoService;
	
	@GetMapping("/")
	public ResponseEntity<List<ProdutoRisco>> getAll(){
		return produtoRiscoService.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<ProdutoRisco> create(@RequestBody ProdutoRisco produtoRisco){
		return produtoRiscoService.create(produtoRisco);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoRisco> getById(@PathVariable("id") long id){
		return produtoRiscoService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return produtoRiscoService.delete(id);
	}
}
