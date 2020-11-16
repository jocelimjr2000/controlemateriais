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

import materiais.models.Deposito;
import materiais.services.DepositoService;


@Controller
@RequestMapping("/api/deposito")
public class DepositoApi {

	@Autowired
	DepositoService depositoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Deposito>> getAll(){
		return depositoService.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Deposito> create(@RequestBody Deposito deposito){
		return depositoService.create(deposito);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Deposito> getById(@PathVariable("id") long id){
		return depositoService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return depositoService.delete(id);
	}
}
