package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import materiais.models.Filial;
import materiais.repositories.FilialRepository;

@Service
public class FilialService extends HelperService<Filial> {

	@Autowired
	FilialRepository repository;
	
	
//	HelperRepository<Filial> repository;
//	
//	@Autowired
//	public FilialService (HelperRepository<Filial> inRepository) {
//		repository = inRepository;
//	}
//
//	// Insert
//	public ResponseEntity<Filial> create(Filial filial) {
//		try {
//			Filial _result = repository.save(filial);
//
//			return new ResponseEntity<>(_result, HttpStatus.CREATED);
//		} catch (Exception e) {
//			System.out.println(e);
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	// Update
//	public ResponseEntity<Filial> update(long id, Filial filial) {
//		Optional<Filial> _result = repository.findById(id);
//		
//		if (_result.isPresent()) {
//			Filial filialData = _result.get();
//			filialData.setNome(filial.getNome());
//			return new ResponseEntity<>(repository.save(filialData), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		}
//	}
//

}
