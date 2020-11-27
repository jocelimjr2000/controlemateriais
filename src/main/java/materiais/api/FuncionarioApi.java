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

import materiais.controllers.FuncionarioController;
import materiais.models.Funcionario;


@Controller
@RequestMapping("/api/funcionario")
public class FuncionarioApi {

	@Autowired
	FuncionarioController funcionarioController;
	
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> getAll(){
		return funcionarioController.getAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
		return funcionarioController.create(funcionario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable("id") long id){
		return funcionarioController.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		return funcionarioController.delete(id);
	}
}
