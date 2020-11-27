package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.NotaFiscal;
import materiais.repositories.NotaFiscalRepository;

public class NotaFiscalService {

	@Autowired
	NotaFiscalRepository notaFiscalRepository;

	// Get All
	public ResponseEntity<List<NotaFiscal>> getAll() {
		try {
			List<NotaFiscal> list = new ArrayList<NotaFiscal>();

			notaFiscalRepository.findAll().forEach(list::add);

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
	public ResponseEntity<NotaFiscal> create(NotaFiscal notaFiscal){
		try {
			NotaFiscal _result = notaFiscalRepository.save(notaFiscal);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// GetById
	public ResponseEntity<NotaFiscal> getById(long id){
		try {
			Optional<NotaFiscal> _result = notaFiscalRepository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id){
		try {
			notaFiscalRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
