package materiais.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import materiais.controllers.FilialController;
import materiais.errors.CustomErrors;
import materiais.models.Filial;

@RestController
@RequestMapping("/api/filial")
public class FilialApi extends CustomErrors {
	
	@Autowired
	FilialController filialController;
	
	@GetMapping("/")
	public ResponseEntity<List<Filial>> getAll() {
		return filialController.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filial> getById(@PathVariable("id") long id) {
		return filialController.getById(id);
	}

	@PostMapping("/")
	public ResponseEntity<Filial> create(@Valid @RequestBody Filial filial) {
		return filialController.create(filial);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filial> update(@PathVariable("id") long id, @Valid @RequestBody Filial filial) {
		filial.setId(id);
		return filialController.update(filial);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		return filialController.delete(id);
	}

}
