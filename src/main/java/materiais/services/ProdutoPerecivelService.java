package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.ProdutoPerecivel;
import materiais.repositories.ProdutoPerecivelRepository;



public class ProdutoPerecivelService {

	@Autowired
	ProdutoPerecivelRepository produtoPerecivelRepository;

	// Get All
	public ResponseEntity<List<ProdutoPerecivel>> getAll() {
		try {
			List<ProdutoPerecivel> list = new ArrayList<ProdutoPerecivel>();

			produtoPerecivelRepository.findAll().forEach(list::add);

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
	public ResponseEntity<ProdutoPerecivel> create(ProdutoPerecivel produtoPerecivel){
		try {
			ProdutoPerecivel _result = produtoPerecivelRepository.save(produtoPerecivel);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// GetById
	public ResponseEntity<ProdutoPerecivel> getById(long id){
		try {
			Optional<ProdutoPerecivel> _result = produtoPerecivelRepository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id){
		try {
			produtoPerecivelRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
