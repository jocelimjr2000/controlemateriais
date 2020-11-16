package materiais.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import materiais.errors.CustomErrors;
import materiais.models.Filial;
import materiais.services.FilialService;

@RestController
@RequestMapping("/api/filial")
public class FilialApi extends CustomErrors {
	
	@Autowired
	FilialService filialService;
	
	@GetMapping("/")
	public ResponseEntity<List<Filial>> getAll(){
		return filialService.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Filial> create(@Valid @RequestBody Filial filial){
		return filialService.create(filial);
	}
	
	
	
}
