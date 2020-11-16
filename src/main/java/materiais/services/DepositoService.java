package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import materiais.models.Deposito;
import materiais.repositories.DepositoRepository;




public class DepositoService {
	@Autowired
	DepositoRepository depositoRepository;

	// Get All
	public ResponseEntity<List<Deposito>> getAll() {
		try {
			List<Deposito> list = new ArrayList<Deposito>();

			depositoRepository.findAll().forEach(list::add);

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
	public ResponseEntity<Deposito> create(Deposito deposito){
		try {
			Deposito _result = depositoRepository.save(deposito);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// GetById
	public ResponseEntity<Deposito> getById(long id){
		try {
			Optional<Deposito> _result = depositoRepository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id){
		try {
			depositoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
