package materiais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import materiais.models.ProdutoPerecivel;

public interface ProdutoPerecivelRepository extends JpaRepository<ProdutoPerecivel, Long> {

}
