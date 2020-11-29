package materiais.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import materiais.models.Compra;
import materiais.services.CompraService;

@Controller
public class CompraController {
	
	@Autowired
	CompraService compraService;

	@Autowired
	FuncionarioController funcionarioController;

	@Autowired
	DepositoController depositoController;

	@Autowired
	ProdutoController produtoController;

	@Autowired
	NotaFiscalController notaFiscalController;
	
	public ResponseEntity<List<Compra>> getAll() {
		return compraService.getAll();
	}
	
	public ResponseEntity<Compra> getById(long id) {
		return compraService.getById(id);
	}
	
	public ResponseEntity<Compra> create(Compra compra) {
		return compraService.create(compra);
	}
	
	public ResponseEntity<HttpStatus> delete(long id) {
		return compraService.delete(id);
	}
	


	public ResponseEntity<Compra> executarCompra(Compra compra) {

		//Verificar Funcionario
		if(funcionarioController.verifyFuncionario(compra.getFuncionario().getCpf())) {

			//Verifica Deposito
			if(depositoController.verifyDeposito(compra.getDeposito().getId())) {

				//Verifica Produto
				if(produtoController.verifyProduto(compra.getProduto().getId())) {

					//Verificar Quantidade a ser inserida
					compra.setProduto(produtoController.verifyQuantity(compra.getProduto(), compra.getQtdeComprada()));

					if(compra.getProduto()!=null) {

						Double valorCompra = (compra.getProduto().getCusto() * compra.getQtdeComprada());
						compra.setNotaFiscal(notaFiscalController.generateNotaFiscal(compra.getQtdeComprada(), valorCompra));
						
						//Salva a Compra
						return compraService.create(compra);
					}
				}
			}
		}
		return null;
	}
}
