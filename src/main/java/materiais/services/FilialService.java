package materiais.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import materiais.models.Filial;
import materiais.repositories.FilialRepository;

@Service
public class FilialService {
	
	@Autowired
	FilialRepository filialRepository;
	
	// Get All
	public ResponseEntity<List<Filial>> getAll() {
		try {
			List<Filial> list = new ArrayList<Filial>();
			
			filialRepository.findAll().forEach(list::add);
			
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert
	public ResponseEntity<Filial> create(@RequestBody Filial filial){
		try {
			Filial _result = filialRepository.save(filial);
			
			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get All
	// Get one
	// Delete
	// Update
}
