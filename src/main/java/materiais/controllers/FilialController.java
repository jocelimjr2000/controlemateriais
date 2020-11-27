package materiais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import materiais.models.Filial;
import materiais.services.FilialService;

public class FilialController {
	
	
	@Autowired
	FilialService filialService;
	
	public ResponseEntity<List<Filial>> getAll() {
		return filialService.getAll();
	}
	
	public ResponseEntity<Filial> getById(long id) {
		return filialService.getById(id);
	}
	
	public ResponseEntity<Filial> create(Filial filial) {
		if(verifyFilial(filial.getId())) {
			return null;
		}
		
		return filialService.create(filial);
	}
	
	public ResponseEntity<Filial> update(Filial filial) {
		return filialService.update(filial.getId(), filial);
	}
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return filialService.delete(id);
	}
	
	public boolean verifyFilial(long id) {
		
		ResponseEntity<Filial> filial = filialService.getById(id);
		
		if (filial.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}
	
}
