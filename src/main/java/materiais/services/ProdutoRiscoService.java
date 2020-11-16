package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import materiais.models.ProdutoRisco;
import materiais.repositories.ProdutoRiscoRepository;




public class ProdutoRiscoService {

	@Autowired
	ProdutoRiscoRepository produtoRiscoRepository;

	// Get All
	public ResponseEntity<List<ProdutoRisco>> getAll() {
		try {
			List<ProdutoRisco> list = new ArrayList<ProdutoRisco>();

			produtoRiscoRepository.findAll().forEach(list::add);

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
	public ResponseEntity<ProdutoRisco> create(ProdutoRisco produtoRisco){
		try {
			ProdutoRisco _result = produtoRiscoRepository.save(produtoRisco);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// GetById
	public ResponseEntity<ProdutoRisco> getById(long id){
		try {
			Optional<ProdutoRisco> _result = produtoRiscoRepository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id){
		try {
			produtoRiscoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
