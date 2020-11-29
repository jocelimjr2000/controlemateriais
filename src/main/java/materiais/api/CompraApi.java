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

import materiais.controllers.CompraController;
import materiais.models.Compra;

@Controller
@RequestMapping("/api/compra")
public class CompraApi {

	@Autowired
	CompraController compraController;
	
	@GetMapping("/")
	public ResponseEntity<List<Compra>> getAll(){
		return compraController.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Compra> executarCompra(@RequestBody Compra compra) {
		return compraController.executarCompra(compra);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compra> getById(@PathVariable("id") long id){
		return compraController.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return compraController.delete(id);
	}
	
}
