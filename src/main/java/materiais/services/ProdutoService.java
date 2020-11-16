package materiais.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.Produto;

import materiais.repositories.ProdutoRepository;

public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	// Get All
	public ResponseEntity<List<Produto>> getAll() {
		try {
			List<Produto> list = new ArrayList<Produto>();

			produtoRepository.findAll().forEach(list::add);

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
	public ResponseEntity<Produto> create(Produto produto){
		try {
			Produto _result = produtoRepository.save(produto);

			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// GetById
	public ResponseEntity<Produto> getById(long id){
		try {
			Optional<Produto> _result = produtoRepository.findById(id);

			return new ResponseEntity<>(_result.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> delete(long id){
		try {
			produtoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
