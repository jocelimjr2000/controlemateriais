package materiais.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import materiais.models.Filial;
import materiais.services.FilialService;

@Controller
@RequestMapping("/api/filial")
public class FilialApi {
	
	@Autowired
	FilialService filialService;
	
	@GetMapping("/")
	public ResponseEntity<List<Filial>> getAll(){
		return filialService.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Filial> create(@RequestBody Filial filial){
		return filialService.create(filial);
	}

}
