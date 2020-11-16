package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unchecked")
public class HelperService<M, R> {

	// protected T modal;
	protected R repository;

	@Autowired
	public HelperService(R inRepository) {
		// this.modal = inModal;
		this.repository = inRepository;
	}

	// Get One
	public ResponseEntity<M> getById(long id) {
		try {
			Optional<M> _result = (Optional<M>) ((JpaRepository<M, Long>) repository).findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get All
	public ResponseEntity<List<M>> getAll() {
		try {
			List<M> _list = new ArrayList<M>();

			((JpaRepository<M, Long>) repository).findAll().forEach((e) -> {
				_list.add((M) e);
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

	// Insert
	public ResponseEntity<M> create(M filial) {
		try {
			M _result = ((JpaRepository<M, Long>) repository).save(filial);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update
	public ResponseEntity<M> update(long id, M filial) {
		Optional<M> _result = ((JpaRepository<M, Long>) repository).findById(id);

		if (_result.isPresent()) {
			return new ResponseEntity<>(((JpaRepository<M, Long>) repository).save(filial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id) {
		Optional<M> _result = (Optional<M>) ((JpaRepository<M, Long>) repository).findById(id);

		if (_result.isPresent()) {
			((JpaRepository<M, Long>) repository).deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
