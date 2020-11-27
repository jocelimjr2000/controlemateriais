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

import materiais.controllers.NotaFiscalController;
import materiais.models.NotaFiscal;



@Controller
@RequestMapping("/api/NotaFiscal")
public class NotaFiscalApi {

	@Autowired
	NotaFiscalController notaFiscalController;
	
	@GetMapping("/")
	public ResponseEntity<List<NotaFiscal>> getAll(){
		return notaFiscalController.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<NotaFiscal> create(@RequestBody NotaFiscal notaFiscal){
		return notaFiscalController.create(notaFiscal);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NotaFiscal> getById(@PathVariable("id") long id){
		return notaFiscalController.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return notaFiscalController.delete(id);
	}
}
