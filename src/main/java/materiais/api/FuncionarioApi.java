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

import materiais.models.Funcionario;
import materiais.services.FuncionarioService;



@Controller
@RequestMapping("/api/funcionario")
public class FuncionarioApi {

	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> getAll(){
		return funcionarioService.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
		return funcionarioService.create(funcionario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable("id") long id){
		return funcionarioService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return funcionarioService.delete(id);
	}
}
