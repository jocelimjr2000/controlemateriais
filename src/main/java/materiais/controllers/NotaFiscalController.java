package materiais.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import materiais.models.Deposito;
import materiais.models.Funcionario;
import materiais.models.NotaFiscal;
import materiais.models.Produto;
import materiais.services.NotaFiscalService;

public class NotaFiscalController {

	@Autowired
	NotaFiscalService notaFiscalService;

	public ResponseEntity<List<NotaFiscal>> getAll() {
		return notaFiscalService.getAll();
	}

	public ResponseEntity<NotaFiscal> getById(long id) {
		return notaFiscalService.getById(id);
	}

	public ResponseEntity<NotaFiscal> create(NotaFiscal notaFiscal) {
		if(verifyNotaFiscal(notaFiscal.getNumero())) {
			return null;
		}

		return notaFiscalService.create(notaFiscal);
	}

	public ResponseEntity<HttpStatus> delete(long id) {
		return notaFiscalService.delete(id);
	}

	public boolean verifyNotaFiscal(long id) {

		ResponseEntity<NotaFiscal> notaFiscal = notaFiscalService.getById(id);

		if (notaFiscal.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		return false;
	}

	public NotaFiscal generateNotaFiscal(int QtdeComprada, Double valorTotal) {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setQuantidadeComprada(QtdeComprada);
		notaFiscal.setValorCompra(valorTotal);
		
		return notaFiscal;
		
	}
}
