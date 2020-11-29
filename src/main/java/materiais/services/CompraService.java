package materiais.services;

import org.springframework.stereotype.Service;

import materiais.models.Compra;
import materiais.repositories.CompraRepository;

@Service
public class CompraService extends HelperService<Compra, CompraRepository>{
	
	public CompraService(CompraRepository inRepository) {
		super(inRepository);
	}

}
