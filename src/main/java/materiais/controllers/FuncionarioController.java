package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import materiais.models.Funcionario;
import materiais.services.FuncionarioService;

public class FuncionarioController {
	
	
	@Autowired
	FuncionarioService funcionarioService;
	
	public ResponseEntity<List<Funcionario>> getAll() {
		return funcionarioService.getAll();
	}
	
	public ResponseEntity<Funcionario> getById(long id) {
		return funcionarioService.getById(id);
	}
	
	public ResponseEntity<Funcionario> create(Funcionario funcionario) {
		if(verifyFuncionario(funcionario.getCpf())) {
			return null;
		}
		
		return funcionarioService.create(funcionario);
	}
	
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return funcionarioService.delete(id);
	}
	
	public boolean verifyFuncionario(long id) {
		
		ResponseEntity<Funcionario> funcionario = funcionarioService.getById(id);
		
		if (funcionario.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}

}
