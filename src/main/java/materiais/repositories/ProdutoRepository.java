package materiais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import materiais.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
