package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.repositories.HelperRepository;

@SuppressWarnings("unchecked")
public class HelperService<T> {
	
	@Autowired
	HelperRepository<T> repository;
	
	// Get One
	public ResponseEntity<T> getById(long id) {
		try {
			Optional<T> _result = (Optional<T>) repository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get All
	public ResponseEntity<List<T>> getAll() {
		try {
			List<T> _list = new ArrayList<T>();

			repository.findAll().forEach((e) -> {
				_list.add((T) e);
			});

			if (_list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(_list, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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

	// Delete
	public ResponseEntity<HttpStatus> delete(long id) {
		Optional<T> _result = (Optional<T>) repository.findById(id);
		
		if (_result.isPresent()) {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
