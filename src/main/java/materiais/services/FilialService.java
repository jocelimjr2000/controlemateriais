package materiais.services;

import org.springframework.stereotype.Service;

import materiais.models.Filial;
import materiais.repositories.FilialRepository;

@Service
public class FilialService extends HelperService<Filial, FilialRepository> {

	public FilialService(FilialRepository inRepository) {
		super(inRepository);
	}

}
