package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import materiais.models.Deposito;
import materiais.services.DepositoService;

@Controller
public class DepositoController {
	
	@Autowired
	DepositoService depositoService;
	
	
	public ResponseEntity<List<Deposito>> getAll() {
		return depositoService.getAll();
	}
	
	public ResponseEntity<Deposito> getById(long id) {
		return depositoService.getById(id);
	}
	
	public ResponseEntity<Deposito> create(Deposito deposito) {
		if(verifyDeposito(deposito.getId())) {
			return null;
		}
		
		return depositoService.create(deposito);
	}
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return depositoService.delete(id);
	}
	
	public boolean verifyDeposito(long id) {
		
		ResponseEntity<Deposito> deposito = depositoService.getById(id);
		
		if (deposito.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}
	
	

}
